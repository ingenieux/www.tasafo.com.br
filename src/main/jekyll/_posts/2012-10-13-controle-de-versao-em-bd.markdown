---
author: mfandrade
comments: true
date: 2012-10-13 05:36:03+00:00
layout: post
slug: controle-de-versao-em-bd
title: Controle de versão em banco de dados com migrations
wordpress_id: 3015
categories:
- Artigos
- técnico
tags:
- banco de dados
- bd
- carbon5
- controle de versão
- integração contínua
- maven
- vcs
---

O desenvolvimento de aplicações em [três camadas](http://en.wikipedia.org/wiki/Three_layer) praticamente tornou ubíqua a persistência de dados em sistemas gerenciadores de bancos de dados. Durante o desenvolvimento, enquanto alterações em artefatos de código-fonte geralmente são controladas com algum sistema de versionamento, alterações em bancos de dados quase nunca são controladas.

Ao codificar, de tempos em tempos o desenvolvedor disponibiliza alterações nos arquivos em que está trabalhando para um repositório. Com artefatos versionados é possível se ter um controle sobre todas as alterações feitas em um dado arquivo, conferir as diferenças entre versões distintas e até retornar arquivos à como seu conteúdo se encontrava num dado momento no passado. Isso tudo além, é claro, de se viabilizar o trabalho concomitante de várias pessoas num mesmo projeto.

Num cenário típico, imagine que um desenvolvedor esteja trabalhando numa dada funcionalidade. Ele codifica, submete alterações ao repositório, codifica novamente. Então o desenvolvedor percebe que será preciso incluir uma nova coluna numa das tabelas no banco de dados. O desenvolvedor então acessa o SGBD e realiza diretamente a adição da coluna na tabela.

Perceba que, enquanto um arquivo de código-fonte evolui por alterações que são controladas (i.e., sabe-se quem fez, quando fez, e até se não era necessária pode-se sempre voltar facilmente à versão anterior), geralmente as alterações feitas em banco de dados não. Por mais metódico que seja o desenvolvedor com respeito às alterações a serem feitas em bancos de dados, no fim das contas sempre há a necessidade de se informar verbalmente a alguém sobre a execução de tais alterações. Vê-se isso muito claramente especialmente quando há mais de um ambiente de banco de dados e surgem as perguntas: _Aquela_ alteração já foi replicada no outro ambiente?

Resumidamente, pode-se dizer que migrations é uma maneira de realizar alterações em um banco de dados de forma organizada e controlada. Trata-se de uma técnica muito comum no desenvolvimento em ambientes modernos de programação, como [Ruby on Rails](http://guides.rubyonrails.org/migrations.html) ou [CakePHP](http://docs.google.com/present/embed?id=d922pns_15cpjjwfgc), por exemplo.

<!-- more -->


## Sobre Migrations


Para se contornar esse cenário, algumas soluções são possíveis, cada qual com suas vantagens e desvantagens. Por exemplo:



Versionar um _full dump_ do banco
    Vantagens:



	
  * pode ser simples para bancos de dados pequenos

	
  * pode ter auxílio de ferramentas gráficas



    Desvantagens:



	
  * ainda necessita de interação humana

	
  * difícil identificar eventuais erros

	
  * o formato do _dump_ deve ser padronizado

	
  * modelagem feita ainda pensando em minimização de impacto de mudanças

	
  * dificuldade em replicar ou transferir dados

	
  * migração de SGBD muito dificultada

	
  * para grandes bancos de dados, pode ser inviável por restrições de espaço



Versionar cada alteração no banco de dados em um arquivo separado
    Vantagens:



	
  * solução que um desenvolvedor metódico talvez adotaria

	
  * pode ter auxílio de ferramentas gráficas



    Desvantagens:



	
  * ainda necessita de interação humana

	
  * eventualmente muitos arquivos a versionar

	
  * modelagem feita ainda pensando em minimização de impacto de mudanças

	
  * dificuldade em replicar ou transferir dados

	
  * migração de SGBD muito dificultada



Utilizar [_fixtures_](http://en.wikipedia.org/wiki/Test_fixture) (p.ex., [DBUnit](http://www.dbunit.org))
    Vantagens:



	
  * economia de espaço e quantidade de arquivos versionados

	
  * pode ter auxílio de ferramentas gráficas



    Desvantagens:



	
  * recurso não é próprio para esta finalidade

	
  * dificuldade em replicar ou transferir dados



[Migrations](http://www.google.com.br/search?q=db+migrations)
    Vantagens:



	
  * fácil identificar o estado atual do banco de dados

	
  * manipulação do banco de dados simplificada e estruturada



    Desvantagens:



	
  * muitos arquivos para versionar

	
  * algumas ferramentas não proveem abstração do SGBD



Neste artigo mostrarei uma abordagem para uso de migrations para controle de versão de banco de dados com Maven, adequado para uso em um ambiente de integração contínua.


### Ferramentas


Pode-se dizer que o conceito de migrations desenvolveu-se juntamente com a popularização do framework Ruby on Rails. Mas também há iniciativas para implementar ou portar tais ferramentas em outras linguagens. A título de referência, seguem links de algumas soluções semelhantes implementadas ou que poderíam ser utilizadas em Java:



	
  * [http://migrate4j.sf.net/](http://migrate4j.sf.net/)

	
  * [http://code.google.com/p/dbmigrate/](http://code.google.com/p/dbmigrate/)

	
  * [http://autopatch.sf.net/](http://autopatch.sf.net/)

	
  * [http://guilhermechapiewski.github.com/simple-db-migrate/](http://guilhermechapiewski.github.com/simple-db-migrate/)

	
  * [http://www.liquibase.org/](http://www.liquibase.org/)

	
  * [http://www.jroller.com/obie/entry/migrator_activerecord_migrations_in_java](http://www.jroller.com/obie/entry/migrator_activerecord_migrations_in_java)

	
  * [http://code.google.com/p/c5-db-migration/](http://code.google.com/p/c5-db-migration/)


Este guia apresenta uma abordagem voltada à ferramenta [Carbon 5](http://code.google.com/p/c5-db-migration/).


### Afinal, o que são migrations?


De uma maneira simplificada, a técnica de migrations é implementada a partir de:



	
  1. um conjunto de representações das alterações feitas no banco de dados;

	
  2. um registro informando qual a última alteração aplicada;

	
  3. um operação para avanço e outra para retrocesso de versão.




#### Conjunto de representações das alterações feitas no banco de dados


O conjunto de representações de alterações a serem feitas no banco de dados pode ser simplesmente uma relação de arquivos .sql. Esta relação precisa estar ordenada, ou seja, deve ser possível identificar qual a primeira a ser aplicada, qual a segunda e assim por diante. Isso é importante para que seja possível aplicar as alterações sequencialmente de forma consistente.

Implementadas como arquivos, a ordenação das alterações pode ser conseguida, p.ex., com um padrão de nomenclatura de arquivos. Por exemplo, um prefixo numérico sequencial cumpre perfeitamente este papel.



	
  1. 00001_criar_tabela_usuarios.sql

	
  2. 00002_popular_tabela_usuarios.sql

	
  3. 00003_incluir_coluna_dta_nascimento.sql

	
  4. 00004_definir_usuario_administrador.sql

	
  5. 00005_criar_tabela_perfis_usuario.sql


Vê-se que a maioria das ferramentas de migrations utiliza um padrão de timestamp, tipo yyyyMMhhmmss como prefixo que provê sequenciamento, identificação única além de não ter limitação quanto à quantidade máxima de arquivos a serem utilizados. Por exemplo:

	
  1. 20101005220000_criar_tabela_usuarios.sql

	
  2. 20101005221701_popular_tabela_usuarios.sql

	
  3. 20101005233529_incluir_coluna_dta_nascimento.sql

	
  4. 20101006030817_definir_usuario_administrador.sql

	
  5. 20101006031154_criar_tabela_perfis_usuario.sql


Utilizar timestamp como prefixo ainda permite identificar mais facilmente o momento em que o migration foi criado. No caso acima, às 22:00 em ponto do dia 5 de outubro de 2010, o desenvolvedor gerou o migration responsável pela criação de uma tabela de usuários no banco. Às 22:17 ele decidiu popular a tabela inserindo alguns valores predefinidos. Após passar pouco mais de uma hora implementando (às 23:35), o desenvolvedor percebeu que seria necessário criar mais uma coluna com a data de nascimento na tabela de usuários. E assim por diante.

O conteúdo dos arquivos .sql são, como de se esperar, as operações SQL que realizam efetivamente as alterações em questão. Pelo que se depreende ainda no exemplo acima, o primeiro migration (20101005220000_criar_tabela_usuarios.sql) provavelmente deve ter uma instrução SQL tipo `CREATE TABLE usuarios ...`.

Estamos assumindo que cada migration é implementado diretamente com o dialeto SQL do SGBD correspondente (caso do Carbon 5). Porém, cabe ressaltar que as ferramentas de migrations mais comuns também fazem abstração do SGBD utilizado, representando definições relativas a banco de dados numa representação em geral mais simples e uniformizada, como o [YAML](http://pt.wikipedia.org/wiki/YAML), por exemplo. Sem depender
dos dialetos SQL dos diferentes SGBDs, eventuais necessidades de se trocar de um SGBD por outro se tornam tarefas bem mais simples.


#### Registro informando qual a última alteração aplicada


Apenas manter o conjunto de alterações realizadas no banco de dados não ajuda muito se não se sabe quais delas estão, de fato, aplicadas ao banco de dados. Num ambiente descontrolado essa informação acaba ficando na cabeça do DBA. Sem registro, muitas vezes para obter essa informação acaba sendo necessário conhecer tudo o que tem sido feito no banco, verificando-o manualmente na tentativa de identificar se seu estado condiz com o desejado. Incertezas advindas desse cenário levam a frequentes limpezas no banco de dados. (Quem nunca teve de parar seu desenvolvimento por um instante porque alguém precisa zerar o banco?)

As ferramentas de migrations geralmente gerenciam a informação das alterações já aplicadas ao banco de dados também como uma tabela no próprio banco de dados. Todo o controle das alterações aplicada é feito automaticamente pela ferramenta de migrations, de forma que esse acompanhamento é feito de forma transparente. No caso da ferramenta Carbon 5, a tabela de controle padrão chama-se `schema_version`.


#### Uma operação para avanço e outra para retrocesso de versão


É comum as ferramentas de migratios disponibilizarem ao menos duas ações: uma que avance a versão do banco de dados para o migration imediatamente posterior na sequência (chamada de **up**) e outra que retrocede a versão para o migration imediatamente anterior ao atualmente aplicado (chamada de **down**).

Além dessas, é comum haver outras ações de conveniência derivadas destas, como por exemplo uma que retorne o banco de dados à primeira versão e outra que aplique todos os migrations pendentes desde o último aplicado. Outras ações disponíveis são combinações dessas básicas. Falaremos com mais detalhes
sobre essas ações ao abordar o Carbon 5 como plugin do Maven mais à frente.


## Migrations em Java via Maven


Como vimos, existem algumas ferramentas de migrations para Java. Para os fins deste guia, optou-se por abordar o [Carbon 5](http://code.google.com/p/c5-db-migration/) essencialmente porque ela já está disponível como [plugin para o Maven](http://code.google.com/p/c5-db-migration/wiki/MavenPlugin), o que facilita seu uso num ambiente de integração contínua.


### Como configurar


Conforme [descrito no site](http://code.google.com/p/c5-db-migration/wiki/MavenPlugin), configurar o suporte ao Carbon 5 em um projeto Maven é bastante simples. São apenas 2 passos no arquivo `pom.xml`:



	
  1. Informar o repositório onde se encontra o plugin:

    
    ...
    <pluginRepositories>
      ...
      <pluginRepository>
        <id>c5-public-repository</id>
        <url><a href="http://mvn.carbonfive.com/public" target="_blank">http://mvn.carbonfive.com/public</a></url>
      </pluginRepository>
    </pluginRepositories>




	
  2. Adicionar o plugin ao build, com a devida configuração do banco de dados (neste caso, um banco MySQL)

    
    ...
    <build>
       ...
      <plugin>
        <groupId>com.carbonfive.db-support</groupId>
        <artifactId>db-migration-maven-plugin</artifactId>
        <version>RELEASE</version>
        <configuration>
          <url>jdbc:mysql://servidor/meubanco</url>
          <username>admin</username>
          <password>53nh4</password>
        </configuration>
        <dependencies>
          <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.6</version>
          </dependency>
        </dependencies>
      </plugin>
    </build>





Este exemplo de configuração foi feito para um banco de dados MySQL chamado `meubanco`, hospedado numa máquina chamada `servidor`, com usuário `admin` e senha `53nh4`. Há ainda outras opções disponíveis. Já para mais detalhes da configuração do Maven (por exemplo, como esconder a configuração de usuário e senha no pom), [consulte seu manual](http://maven.apache.org/pom.html) ou peça
auxílio ao gestor de configuração de seu projeto.

A propósito, mostramos neste exemplo uma configuração para uma banco MySQL, mas o Carbon 5 tem suporte para diversos SGBDs com conexão via JDBC, entre eles: MYSQL, POSTGRESQL, SQL_SERVER, HSQL, H2, DB2 e ORACLE.


### Como utilizar


Uma vez configurado o suporte ao Carbon 5 em seu projeto, [estarão disponíveis](http://code.google.com/p/c5-db-migration/wiki/MavenPlugin#Maven_Plugin_Goal_Reference) os seguintes _goals_ no Maven:



`db-migration:migrate`
    Aplica todos os migrations ainda pendentes
`db-migration:drop`
    Destroi a base de dados
`db-migration:reset`
    Destroi a base de dados e a reconstroi aplicando todos os migrations ainda pendentes (combinação dos anteriores)
`db-migration:create`
    Cria o esquema do banco de dados se ele ainda não existir (caso contrário, falha o build)
`db-migration:validate`
    Informa se a base está atualizada ou informa quais migrations ainda não foram aplicados
Destes, o `db-migration:migrate` sem dúvida é o mais importante. Como dito, este _goal_ atualiza o banco de dados aplicando todos os migrations pendentes.

Repare que a versão atual Carbon 5 não dispõe de _goals_ implementando as ações `up` e `down` para aplicar ou desaplicar apenas um migration por vez, mas apenas os de voltar o banco à situação inicial e aplicar todos os migrations.


#### Cenário concreto


Suponha que queiramos começar com um novo banco de dados já configurado. Se tudo estiver funcioando corretamente, podemos começar a escrever nossos migrations.

Imagine que queremos criar uma tabela de usuários tal como no exemplo ilustrativo do começo deste guia. Para tal, podemos começar a escrever nossos migrations. O local padrão onde o Carbon 5 procura os migrations é na subpasta `src/main/db/migrations` na raiz de um projeto Maven (lembrando que isto também pode ser configurado). Para um migration que crie uma tabela de usuários, basta criar um arquivo de texto plano contendo a instrução SQL correspondente. Por exemplo, poderia ser:

    
    CREATE TABLE usuarios (
    	id		integer not null primary key auto_increment,
    	login		varchar(16) not null,
    	password	varchar(40) not null,
    	fullname	varchar(60) not null,
    );


Criado este arquivo, podemos salvá-lo na pasta de migrations padrão em `src/main/db/migrations` dentro de nosso projeto Maven. Como já mencionado, o padrão de nomes envolve um prefixo yyyyMMhhmmss. Enquanto escrevo este trecho deste guia, agora são 18:10 do dia 06 de outubro. Podemos salvar nosso arquivo com uma representação timestamp deste horário. Portanto, o caminho completo de nosso migration dentro do projeto Maven será `/src/main/db/migrations/20101006181000_criar_tabela_usuarios.sql`.

Muito chato salvar arquivos com esse prefixo de timestamp! Não falamos, mas para auxiliar nisso, você poderia ter simplesmente executado o _goal_ `db-migration:new -Dname=criar_tabela_usuarios`. O parâmetro `name` é opcional e não precisa ser informado, mas é sempre bom para identificar mais claramente o que o migration faz. Este é um _goal_ auxiliar que apenas já cria um arquivo .sql vazio devidamente nomeado no local padrão.

Seguindo em frente. Uma vez salvo o arquivo, podemos utilizar a ferramenta para confirmar o estado do banco com `db-migration:validate`. Ao executar um build assim neste momento, obteremos a seguinte saída:

    
    $ mvn db-migration:validate
    [INFO] Scanning for projects...
    [INFO] ------------------------------------------------------------------------
    [INFO] Building prjdbmigrate
    [INFO]    task-segment: [db-migration:validate]
    [INFO] ------------------------------------------------------------------------
    [INFO] [db-migration:validate {execution: default-cli}]
    [INFO] Validating jdbc:mysql://localhost/meubanco using migrations at src/main/db/migrations/.
    [INFO] Loaded JDBC driver: com.mysql.jdbc.Driver
    [INFO] 
                Database: jdbc:mysql://localhost/meubanco
              Up-to-date: false
      Pending Migrations: 20101006181000_criar_tabela_usuarios.sql
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESSFUL
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 1 second
    [INFO] Finished at: Wed Oct 06 18:17:55 BRT 2010
    [INFO] Final Memory: 8M/122M
    [INFO] ------------------------------------------------------------------------


O Maven então nos informa que a base não está atualizada (`Up-to-date: false`) pois o migration que acabamos de criar ainda não foi aplicado (`Pending Migrations: 20101006181000_criar_tabela_usuarios.sql`). De fato, como ainda não fizemos nada, se acessarmos o banco de dados neste momento, como dito, veremos que ele ainda se encontrará vazio.

Vamos aplicar todos os migrations pendentes com `db-migration:migrate`. Teremos então a seguinte saída:

    
    $ mvn db-migration:migrate
    [INFO] Scanning for projects...
    [INFO] ------------------------------------------------------------------------
    [INFO] Building prjdbmigrate
    [INFO]    task-segment: [db-migration:migrate]
    [INFO] ------------------------------------------------------------------------
    [INFO] [db-migration:migrate {execution: default-cli}]
    [INFO] Migrating jdbc:mysql://localhost/meubanco using migrations at src/main/db/migrations/.
    [INFO] Loaded JDBC driver: com.mysql.jdbc.Driver
    [INFO] Successfully enabled migrations.
    [INFO] Migrating database... applying 1 migration.
    [INFO] Running migration 20101006181000_criar_tabela_usuarios.sql.
    [INFO] Migrated database in 0:00:00.030.
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESSFUL
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 1 second
    [INFO] Finished at: Wed Oct 06 18:22:02 BRT 2010
    [INFO] Final Memory: 8M/122M
    [INFO] ------------------------------------------------------------------------


Apenas dados informativos indicando que o comando SQL no arquivo de migration foi aplicado com sucesso (`Running migration 20101006181000_criar_tabela_usuarios.sql.`). Acessando o banco de dados agora pode-se confirmar que, de fato, o comando SQL foi executado e a tabela foi criada. Ou podemos apenas verificar novamente com um `db-migration:validate`:

    
    $ mvn db-migration:validate
    [INFO] Scanning for projects...
    [INFO] ------------------------------------------------------------------------
    [INFO] Building prjdbmigrate
    [INFO]    task-segment: [db-migration:validate]
    [INFO] ------------------------------------------------------------------------
    [INFO] [db-migration:validate {execution: default-cli}]
    [INFO] Validating jdbc:mysql://localhost/meubanco using migrations at src/main/db/migrations/.
    [INFO] Loaded JDBC driver: com.mysql.jdbc.Driver
    [INFO] 
                Database: jdbc:mysql://localhost/prjdbmigrate
              Up-to-date: true
      Pending Migrations: 
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESSFUL
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 1 second
    [INFO] Finished at: Wed Oct 06 18:24:51 BRT 2010
    [INFO] Final Memory: 8M/122M
    [INFO] ------------------------------------------------------------------------


Como podemos ver, a base de dados agora está atualizada e não há migrations ainda não aplicados.

Muito bom! Vamos agora inserir alguns registros nessa tabela. Como já sabemos, podemos fazer isso via Maven. Primeiro um `db-migration:new -Dname=popular_tabela_usuarios`. Editamos o arquivo .sql em branco recém-criado em `src/main/db/migrations` com os devidos comandos `INSERTO INTO usuarios (...`. Depois de salvá-lo, podemos executar
um `db-migration:migrate` para executá-lo. O ciclo incremento das versões é sempre este.

Hum... Mas só agora lembrei que precisamos guardar também a informação da data de nascimento de cada usuário. Calma! Antes de retornar ao arquivo .sql e refazer o `CREATE TABLE`, vale destacar a regra de ouro do versionamento de banco de dados: Migration criado não se altera.

A ideia do versionamento de banco de dados é justamente possibilitar o controle da evolução do banco de dados ao longo do tempo. Assim, a menos que você tenha cometido um erro de sintaxe no comando SQL dentro do arquivo e ele não consiga ser executado, **nunca modifique o conteúdo de um arquivo de migration**.

Ao invés disso, evolua o estado do banco de dados criando um novo campo nascimento na tabela usuários, podemos fazer um `ALTER TABLE`. Crie o novo migration executando um build com `db-migration:new -Dname=incluir_coluna_dta_nascimento`. Edite o recém-criado arquivo incluindo seu conteúdo com `ALTER TABLE usuarios ADD dta_nascimento date not null;` e aplíque-o executando
`db-migration:migrate` via Maven.

Pronto! O banco está evoluindo e suas alterações estão devidamente controladas.
  *[YAML]: YAML Ain't Markup Language
