status=published
date=2009-05-14
tags=blog
type=post
title=Se você não testa, você não é ágil!
~~~~~~
O colega Robson Pelegrini [reportou na lista [scrum-brasil]](http://br.groups.yahoo.com/group/scrum-brasil/message/3348) uma situação que é comum, principalmente em equipes que estão iniciando no desenvolvimento ágil de software e que (com a devida autorização) transcrevo abaixo:


> Pessoal,

Gostaria de saber como vocês tratam a questão dos bugs que surgem dentro do SPRINT, por exemplo:

> 
> 
	
>   * Criam um item no SPRINT BACKLOG, “correção de bugs”
> 
	
>   * Bugs é responsabilidade do time concertar, não podendo esse impactar na entrega do SPRINT
> 

Acredito que a partir da 1ª entrega feito ao PO, temos o que podemos chamar de “legado”, e então começam a surgir bugs e mudanças de requisitos e funcionalidades que geralmente afetam o planejamento feito para o próximo SPRINT.

- Isso costuma ocorrer com vocês ? Como vocês lidam com essas situações ?


Necessário pontuar algumas coisas num cenário como este.  Vamos a elas.

**O QUE VEM A SER UM "BUG" DE SOFTWARE?![software-bug-03](http://tasafo.files.wordpress.com/2009/05/software-bug-03.jpg?w=150)**

Como seres humanos, todos estamos sujeitos a erros.  Assim, mais ainda quando estamos lidando com um produto em desenvolvimento, ou seja, que está sendo construindo.  Muitos projetos de software mantém dois ramos do produto --um estável e um em desenvolvimento-- justamente para diferir a quantidade de bugs em potencial que podem estar contidos no produto.

Se por um lado tudo isso é verdade, por outro, quando tratamos de desenvolvimento ágil de software, deve-se partir da premissa de que a cada iteração no ciclo de desenvolvimento um item de valor deve ser entregue ao cliente.  São os releases curtos.

Isto posto, cabe nos perguntarmos: afinal o que é um "bug" de software?

<!-- more -->Apesar de geralmente chamarmos a qualquer problema com software de "bug", no livro _"Qualidade de Software"_, [Koscianski e Soares](http://www.novateceditora.com.br/livros/qualidadesoftware2/) fazem uma boa diferenciação destes em DEFEITOS e FALHAS.  Um _defeito_ costuma ser uma imperfeição do software.  Uma situação que deveria ser considerada mas não o é.  De uma maneira simples, **defeituoso é aquilo que simplesmente não funciona como deveria**.  Já uma _falha_ é a manifestação de um problema.  Mesmo que contenha defeitos, um software pode funcionar sem apresentar necessariamente uma falha.  Enquanto defeito é uma situação não prevista pelo software, uma falha geralmente se apresenta por problemas no tratamento de erros do software.

**DEFINIÇÃO DE PRONTO**

Pois bem. A questão então passa a ser como identificar e isolar defeitos do produto na busca por corrigí-los, evitá-los ou tratá-los adequadamente, sempre de forma a atender às necessidades do cliente.

![checklist](http://tasafo.files.wordpress.com/2009/05/checklist2.jpg?w=150)Voltando ao cenário do começo do post.  Se a equipe deu como concluído um item do _backlog_ em um sprint anterior e, algum tempo depois percebeu-se que tal item está defeituoso (ou seja, uma dada história sobre aquele item não funciona como esperado), vem a pergunta: **será que o item estava de fato pronto?** Ou melhor**: como se sabe se um item está de fato pronto?**

A resposta a tal pergunta pode estar relacionada a um conceito essencial mas que pode ser negligenciado em algumas equipes (principalmente as mais inexperientes em metodologias ágeis) que é a DEFINIÇÃO DE PRONTO (_Definition of Done_).  Como de se supor, a_ [definição de pronto](http://agilesoftwaredevelopment.com/2006/05/definition-of-done)_ deve ser um critério objetivo, inequívoco e facilmente verificável e que possa servir de marco para se considerar uma determinada tarefa, um item ou uma funcionalidade do software como concluída.

**TESTES AUTOMATIZADOS**

É comum nas equipes com pouca experiência em desenvolvimento ágil, que o desenvolvedor "entenda" o que deve ser feito após uma orientação ou uma conversa com o líder do projeto ou do cliente.  E então implemente o que entendeu.  E então que execute o sistema para testar o que fez.  Nessa desfavorável situação, as coisas facilmente saem dos eixos por vários motivos:



**O desenvolvedor nunca entende toda a demanda, por mais simples que ela seja.**
    No contexto do desenvolvimento, a pessoa que melhor entende do negócio. A especialidade do desenvolvedor são as linguagens, as técnicas, os algoritmos e aspectos da construção do software. A priori, o desenvolvedor não deve ter obrigação de conhecer a fundo toda a lógica de negócio do cliente.  Além disso, sem conhecer toda a lógica do negócio, o desenvolvedor pode ter dificuldades em executar o software de forma a disparar certas situações específicas e/ou incomuns;
**O desenvolvedor pode estar (e comumente está) sob pressão.**
    Prazos, custos e produtividade são algumas das cobranças às quais o desenvolvedor está sujeito. Não se deve estranhar que tais pressões resultem em alguma pressa ou ansiedade. Em equipes muito heterogêneas que não adote algumas padronizações ou revisões de código, isto pode resultar em grande risco à qualidade do produto;
**O desenvolvedor busca naturalmente pelo "caminho feliz".**
    Basicamente, buscando reduzir tempo dispendido no uso para averiguação do sistema, conforme vai avançando em suas atividades, é natural que desenvolvedor limite-se a executar os cenários que sabe com que o sistema funcionará. Testes que o desenvolvedor executa no sistema sobre aquilo que desenvolveu tendem a ser viciados e podem não ser muito confiáveis. A preocupação acaba sendo "ver o software funcionar" e não propriamente "testar o software";
O ponto chave aqui é que o desenvolvedor nunca é a melhor pessoa para testar o que ele mesmo escreveu.  Para distanciar o elemento humano da atividade de teste é que se recomenda fortemente que seus testes de software sejam realizados de forma automatizada.  A escrita de testes ([unitários](http://pt.wikipedia.org/wiki/Teste_unitário), [de integração](http://thinkabouttests.blogspot.com/2008/02/teste-de-integrao.html), [de aceitação](http://gc.blog.br/2007/09/26/voce-automatiza-seus-testes-de-aceitacao/)... enfim, todos os possíveis) e sua execução de forma automatizada são um excelente ponto de partida para o estabelecimento de definição de pronto: um item ou tarefa está concluído se passou no teste correspondente.

Além do que, com a escrita de testes automatizados, você também mantém registro documental das lógicas de negócio de sua aplicação, reforçando o entendimento do negócio e facilitando a integração de novos membros de trabalho à equipe.

Assim, se você não quiser terminar com um sistema de [bugtracking](http://en.wikipedia.org/wiki/Bug_tracking_system) cheio de itens "teoricamente prontos" mas repletos de defeitos, teste sempre seus software de forma automatizada.  Testes automatizados são imprescindíveis, de forma que...


> **SE VOCÊ NÃO TESTA, VOCÊ NÃO É ÁGIL!**

**
**





* * *



Testes de software, ferramentas, relatos de experiências com Scrum e muito mais sobre desenvolvimento ágil estarão nos próximos posts.  Acompanhe os [feeds do Tá Safo](http://tasafo.wordpress.com/feed/) e não perca!

Comentem!  Participem!  Nos vemos no [Academic Meeting!](http://tasafo.wordpress.com/2009/04/30/evento-visao-agil-academic-meeting-2009/) Até a próxima!****


