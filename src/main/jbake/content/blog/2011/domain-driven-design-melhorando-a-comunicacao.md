status=published
date=2011-10-19
tags=blog
type=post
title=Domain Driven Design - Melhorando a comunicação
~~~~~~
Software é complexidade. E tal complexidade vem diretamente do domínio do problema ao qual o software se destina a resolver. É aqui que entram uma série de práticas voltadas a tentar combater ou mesmo amenizar tal complexidade. A criação de um modelo de domínio é uma delas.

Um modelo é uma simplificação, uma interpretação de algo mais complexo no qual gostaríamos de mostrar os aspectos mais relevantes. Um modelo de domínio serve como base para uma comunicação entre as pessoas que participam de um projeto. Esta comunicação deve ser realizada através de uma linguagem que facilite a interação entre pessoas que possuem visões diferentes sobre o domínio.

Em um projeto de software podemos encontrar vários perfis de profissionais. Os especialistas de negócio possuem sua própria linguagem, seus próprios jargões técnicos sobre o domínio. Diferente dos desenvolvedores que, por sua vez, possuem seus próprios conceitos para se referenciar ao domínio, muitas das vezes mais voltado para a solução.

Para os desenvolvedores torna-se difícil entender o domínio, algo novo, algo complexo, passado a eles através de uma linguagem que não compreendem muito bem. Alguns até se destacam e conseguem falar as duas linguagens, mas isso é mais um problema do que solução. A comunicação torna-se uma via de mão dupla. Tendo de ser traduzida a todo instante. Esse é o grande mal que aflige os projetos de software. Uma tradução mal interpretada pode colocar tudo a perder.

<!-- more -->

Por isso a necessidade de uma linguagem ubíquoa de alto nível que esteja presente em todos os cantos do projeto. E que seja capaz, não só de descrever artefatos de sistema, mas também, tarefas e funcionalidades. Essa linguagem deve atender a desenvolvedores e especialistas no domínio para que possam se comunicar uns com os outros e entre si. Pelo menos, no mundo ideal seria assim. Não é tão fácil manter uma linguagem ubíqua. É preciso um compromisso forte por parte dos membros da equipe para o uso da linguagem baseada no modelo.

**Diagramas**

A maioria das pessoas são visuais e os diagramas auxiliam na obtenção e no entendimento de informações. A [UML](http://pt.wikipedia.org/wiki/UML) é uma ferramenta muito boa nesse aspecto. Diagramas [UML](http://pt.wikipedia.org/wiki/UML) podem ajudar a ententer fluxos e interações. No entanto, a [UML](http://pt.wikipedia.org/wiki/UML) não é a melhor forma de se modelar um domínio. Diagramas [UML](http://pt.wikipedia.org/wiki/UML) complexos podem vir a ser de difícil compreensão. Há muito trabalho para interpretá-los e muito para constuí-los e modificá-los. São completos demais e mesmo assim deixam muita coisa de fora. Sobrecarregam o leitor com muitos detalhes e pouco significado.

Detalhes relevantes do design ficam no código.  Diagramas devem abordar os pontos principais como complemento ao modelo de domínio. O diagrama não é o modelo, não deve ser encarado como modelo. Ele é só uma forma de ajudar na comunicação. Código bem escrito é tão explicativo quanto um diagrama.

**Documentos de texto**

A comunicação _face to face_ vem sendo cada vez mais enfatizada, principalmente com a força que os métodos ágeis vem adquirindo ao longo dos anos. No entanto, documentos escritos são uma necessidade. Mas criar documentos que realmente agreguem valor a equipe é um desafio.

O grande problema com relação a isto é que software evolui. Software muda, a linguagem do projeto muda, código muda e os documentos são deixados para trás. Vendo dessa forma, o [Extreme Programming](http://www.extremeprogramming.org/) prega que a melhor documentação que existe é o código. Pois o código dificilmente vai mentir. Documentos mentem e até comentários no código mentem. Isso acontece pois documentos e comentários não afetam o comportamento do software por isso eles sempre saem de sincronia com o código. Logo ficamos altamente dependentes do código como meio de comunicação. Dai a importância do [código limpo](http://www.infoq.com/br/articles/clean-code-book-review).

Mas código como documento tem alguns problemas. Possui muitos detalhes. Mesmo que ele seja limpo, pode não ser tão óbvio. E os desenvolvedores não são os únicos que precisam entender o modelo de domínio. Dai a importância de bons documentos e bons diagramas. Mas diagramas e documentos não devem tentar fazer o que o código já faz bem. Eles devem se complementar.

Os termos presentes no documento devem aparecer nas conversas face a face, nos diagramas e no código. Isso caracteriza a linguagem onipresente. No entanto a linguagem onipresente pode evoluir. Os documentos devem sobreviver a esta evolução e estar sempre em sintonia com o projeto. Caso contrário, tornam-se mais um desperdício.

**Código**

Código precisa transmitir significado. Também precisa estar em sintonia com o projeto. A linguagem ubíqua precisa estar presente no código. Este é o cerne do [Domain Driven Design](http://en.wikipedia.org/wiki/Domain-driven_design). No entanto, isso requer um alto grau de disciplina. Porque até mesmo o código pode mentir. Por exemplo, o nome de um método que não condiz com o seu comportamento. O código não deve somente fazer a coisa certa, mas também, deve dizer a coisa certa.

Apesar de o código mentir, ele sem dúvida, é o artefato que mais se aproxima da realidade do domínio. Por isso deve utilizar a mesma linguagem usada nos requisitos e nas conversas. A linguagem ubíqua, onipresente, voltada ao modelo de domínio.

[Domain Driven Design](http://en.wikipedia.org/wiki/Domain-driven_design) é um assunto muito extenso. Esta foi só uma rápida abordagem sobre fatores que afetam a comunicação. Vamos esperar os próximos posts.
