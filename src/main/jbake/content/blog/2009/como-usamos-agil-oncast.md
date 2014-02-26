status=published
date=2009-09-13
tags=blog
type=post
title=Como usamos Ágil: OnCast
~~~~~~
Este é o primeiro artigo de uma série intitulada "Como usamos Ágil". Tendo como inspiração o livro "Scrum e XP direto das trincheiras" (Scrum and XP from the trenches), de Henrik Kniberg, no qual ele conta em detalhes como usa Scrum e XP, pretendemos entrevistar algumas empresas brasileiras que usam metodologias ágeis no seu dia-a-dia.

Sabemos que a principal dificuldade encontrada por iniciantes em Ágil é justamente pôr em prática tudo o que estudou. Principalmente porque a grande maioria das empresas ainda não adotou tais metodologias, somos muitas vezes pioneiros em adotar Ágil na empresa em que trabalhamos.

Diferente dos livros que dizem **o que** devemos fazer, mostrar de forma prática **como** as empresas usam as metodologias pode ajudar a diminuir a distância que separa a teoria da prática, e de repente evitar que alguns erros sejam cometidos devido à inexperiência. Esse é o principal objetivo desta série.

A primeira empresa entrevistada foi a [OnCast](http://www.oncast.com.br/), de Florianópolis, Santa Catarina. Entrevistei Samuel Crescêncio, um dos fundadores da empresa. Segue o resultado dessa entrevista:

<!-- more -->**TaSafo: **Quais metodologias ágeis são utilizadas na OnCast?**
**

**OnCast: **Usamos um _mix_ de práticas baseadas nos nossos princípios que são adaptadas ao contexto dos projetos. Temos como base da nossa cultura os princípios de Lean e do manifesto ágil. Para implementar os conceitos ágeis, nós temos uma figura que é parecida com uma pirâmide: no topo, temos Lean e os nossos valores, que é o que define nossa cultura; na parte intermediária, temos a área de gestão de projetos, onde normalmente usamos Scrum, e em alguns casos um modelo parecido com Lean; na base da pirâmide, temos a engenharia de software, que é onde utilizamos algumas práticas do XP, como os testes automatizados, integração contínua, simplicidade e refatoração constante, que dão sustentabilidade para que possamos obter os valores das metodologias que utilizamos.

**TaSafo: **Quais práticas desse mix Lean + Scrum + XP são utilizadas por vocês?

**OnCast: **Utilizamos o Scrum na íntegra. Já do XP, fazemos programação em par para transferência de conhecimento para um novo membro da equipe e para tarefas complexas; fazemos _move people around _para promover um conhecimento amplo sobre o código para todos dentro das equipes. Além disso, utilizamos código coletivo; integração contínua; testes em todos os níveis (unidade, integração, funcionais, aceitação), em sua maioria automatizados; em alguns casos, utilizamos TDD.

**TaSafo:** Em relação ao Scrum...
Como fazem o _product backlog_?

**OnCast:** Uma pessoa responsável pelos projetos da OnCast se reúne com o cliente para viabilizar e estimar o projeto. Salientamos nesse momento que essa estimativa é muito crua, e que uma estimativa mais real e detalhada será feita pela equipe de desenvolvimento. Nesse momento criamos algumas estórias de alto nível, que farão parte do product backlog. Durante o desenvolvimento o backlog geralmente é alterado.

**TaSafo: **Qual o tempo de um _sprint_?

**OnCast:** Isso varia de projeto para projeto. Mais além: temos projetos que o tempo do _sprint_ é fixo; em outros é variável. Usamos _sprints_ menores em projetos pequenos para aumentar o _feedbak_, o aprendizado e a correção de problemas. Em projetos mais longos, podemos usar _sprints_ maiores.

**TaSafo:** Quem é o _product owner_ (PO) e como ele age?

**OnCast:** Nesse caso o Scrum é bem interessante para nós. Como fornecemos _outsourcing_, o Scrum promove uma boa separação de papéis e responsabilidades: o PO fica responsável pelo negócio, enquanto que a equipe cuida da tecnologia. Muitas vezes o cliente possui vários _stakeholders_ para um projeto, então a centralização de um único PO como o representante deles no projeto é muito importante. Esse PO é quem participa das reuniões de planejamento, nas quais o PO vai até a sede da OnCast ou a nossa equipe vai até o cliente. Além disso, temos comunicação direta com o PO pessoalmente ou através de telefone, e-mails, etc.

**TaSafo:** O que acontece se o time percebe que não vai conseguir entregar o _sprint backlog_?

**OnCast:** Nós sempre trabalhamos de forma colaborativa com o nosso PO, então sempre informamos os problemas a ele, deixando o projeto com boa visibilidade. De qualquer forma, quando acontece um problema crítico, utilizamos uma técnica do Lean, que se chama_ stop-the-line_, que significa: parar a linha de produção, corrigir o problema pela raiz, para então voltar à linha de produção. Então, quando usamos _stop-the-line_, dependendo do problema a iteração inteira pode ser cancelada, mas o que geralmente acontece é que tomamos algumas ações para mitigar aquele risco ou para diminuir o impacto daquele problema no final da iteração, objetivando manter o prazo da iteração inalterado e entregando software com valor agregado ao cliente. Pode ser que precisemos cortar escopo, então fazemos isso junto ao PO. Assim como nós podemos querer alterar o _product backlog_, o cliente às vezes identifica que suas prioridades mudaram no meio do _sprint_. Fazemos então o _stop-the-line_, damos a oportunidade para ele substituir funcionalidades por outras de mesmo valor. Nós não pegamos mais capacidade do que aquela que podemos produzir. Conhecemos nossa velocidade e o esforço das estórias, então permitimos que o PO altere as estórias de modo que elas se adequem a nossa velocidade.

**TaSafo: **E quanto aos _bugs_ encontrados após o término do _sprint_, o que acontece com eles?

**OnCast: **Ao ser notificada de um _bug_, a equipe imediatamente cria um item no _backlog_ (estória), que será priorizado pelo PO. Dependendo da prioridade esse item pode entrar no _sprint_ em andamento, ou nos próximos _sprints_. Como os _bugs_ sempre entram no _product backlog_, não usamos ferramentas de _bug tracking_ para gerenciar isso.

**TaSafo:** Existem várias equipes trabalhando simultaneamente? Quantas pessoas cada equipe possui?

**OnCast:** Isso depende das necessidades de cada projeto. Hoje temos 5 equipes trabalhando em projetos diferentes. Em geral as equipes têm de 4 a 6 pessoas, mas já tivemos equipes de 2 e 3 pessoas para projetos menores.

**TaSafo:** Ao término de um projeto, o que acontece com a equipe de desenvolvimento?

**OnCast:** Como trabalhamos com prestação de serviços, estamos sempre preocupados com a demanda de projetos e relacionamos isso com a nossa capacidade produtiva. Então estamos sempre prospectando novos projetos, constantemente visitando clientes e avaliando oportunidades. O que tem acontecido ultimamente é que as equipes não têm ficado desalocadas. No dia seguinte após o término de um projeto, tem outro esperando para começar.
Mas quando ocorre de uma equipe ficar ociosa entre um projeto e outro, ela fica livre para inovar, adquirir conhecimento ou mesmo para trabalhar nos nossos projetos _open-source_.

**TaSafo:** Como é o ambiente físico de trabalho? As equipes ficam distribuídas geograficamente?

**OnCast:** Nós temos 2 laboratórios de desenvolvimento: um deles possui um ambiente todo aberto e grande, não possui divisórias entre as mesas, todo mundo fica no mesmo cômodo; o outro é uma casa que foi transformada em laboratório. Nele, as equipes se instalam nas dependências da casa. Nessa casa, temos um _lounge_ com uns puffs onde o pessoal costuma relaxar, tirar uma soneca depois do almoço, etc. O pessoal está até querendo botar um videogame lá. Temos uma cultura de liberdade e tentamos deixar o pessoal bem à vontade. Por exemplo, no verão, as pessoas gostam de ir trabalhar de bermuda e chinelo de dedo; temos um horário de trabalho flexível, desde que respeite as necessidades do time. Tentamos deixar as pessoas confortáveis, porque o objetivo é promover a criatividade, então o ambiente lá é bem aberto.

<div id="attachment_361" class="wp-caption" align="alignleft" style="width: 259px"><p class="wp-caption-text"></p></div>
![Daily meeting de uma equipe](http://tasafo.files.wordpress.com/2009/09/daily-meeting-oncast.jpg?w=300)

Com relação ao _daily meeting_, sempre fazemos na frente do _dashboard_. Cada equipe possui um _dashboard_ e um _burndown chart_ e é lá que ocorre o _daily meeting_. Não existe a obrigatoriedade de ficar em pé, mas seguimos a regra de 15 minutos para a reunião, nos quais as pessoas devem responder as 3 perguntas do _daily Scrum__ meeting_.

**TaSafo:** Como são feitos os contratos entre a empresa e os clientes? Vocês usam contrato de escopo negociável?

**OnCast:** No início foi difícil vender o primeiro projeto de escopo aberto. O cliente não queria e acabamos fechando um projeto com escopo fechado. Trabalhamos utilizando práticas ágeis, estimando com _story points_ e oferecemos ao cliente a possibilidade de mudar o escopo, contanto que não alterasse o custo final do projeto, ou seja, ele poderia trocar uma funcionalidade que custasse 3 _story points_ e colocar outra que também custasse 3 _story points_.

Depois disso nós conseguimos estabelecer um relacionamento muito interessante com os clientes e passamos a usar um modelo de contrato de escopo negociável. Nesse caso, nós fechamos o custo por hora, sem cobrar valores diferenciados para os membros da equipe. Dessa forma nós fechamos um valor por equipe, e não por pessoa. Funciona assim: o cliente tem um projeto e pede uma equipe de 4 pessoas para desenvolvê-lo. Fazemos então uma estimativa na qual achamos que, por exemplo, 6 meses de desenvolvimento para a equipe de 4 pessoas são suficientes. A partir de então o cliente paga mensalmente o que foi gasto em esforço naquele mês. Já ocorreram casos de projetos menores, em que fizemos uma estimativa e gastamos menos esforço. Nesses casos, nós só cobramos pelo esforço entregue, mesmo que a estimativa tenha sido maior. Com isso o cliente adquiriu confiança na empresa, o que nos permitiu usar contratos de escopo negociável.

Hoje só usamos esse tipo de contrato (de escopo negociável) e até recusamos alguns contratos de escopo fechado. Com o tempo, nós adquirimos uma certa habilidade em conversar sobre os processos ágeis e mostrar os nossos casos de sucesso, então quando um cliente aparece com um projeto de escopo fechado, geralmente acabamos convencendo-o de que o modelo de escopo negociável será muito mais interessante para ele.

**TaSafo:** Existe algum aspecto que marca seu método? Algum toque especial fora do padrão da metodologia (nesse caso, fora do Scrum)?

**OnCast:** Sim, utilizamos a análise SWOT para as retrospectivas. Avaliamos as forças e fraquezas daquilo que está sob o controle do time (aspectos internos) e as oportunidades e ameaças do que é externo ao time. É muito legal fazer isso e tem sido um ponto fundamental no nosso processo de melhoria contínua.

<div id="attachment_360" class="wp-caption" align="alignright" style="width: 259px"><p class="wp-caption-text"></p></div>
![Dashboard](http://tasafo.files.wordpress.com/2009/09/dashboard.jpg?w=300)

Utilizamos o Scrum também para gerenciar outras áreas da empresa, como o marketing e o administrativo-financeiro. Nesses casos utilizamos um _dashboard_ diferenciado, que também é um _kanban_, com as tarefas a fazer, o que está sendo feito e o que já foi feito, mas criamos um esquema de priorização diferenciado, que é distribuído ao longo das datas. Com isso, temos visibilidade e não corremos o risco de esquecer de fazer alguma coisa a ser feita em determinada data. O interessante é que estamos conseguindo aumentar bastante a produtividade desses 2 setores utilizando Scrum, isso é bem legal.
