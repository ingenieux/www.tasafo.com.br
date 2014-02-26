status=published
date=2012-03-26
tags=blog
type=post
title=Os custos ocultos do débito técnico
~~~~~~
O débito técnico, na definição de Rodrigo Machado, é a distância entre o estado atual de um artefato técnico e como ele o seria em seu estado da arte. Acesse [o artigo que ele escreveu](http://onca.st/blog/?p=591) para saber mais sobre a definição e outras discussões. Este artigo aborda uma questão que nós, geralmente, não prestamos atenção no dia a dia: como reagimos psicologicamente quando fazemos um trabalho ruim?

[![](https://tasafo.files.wordpress.com/2012/03/ansiedade.jpg)](https://tasafo.files.wordpress.com/2012/03/ansiedade.jpg)

Veja o seguinte relato:


> A pressão por resultados rápidos me impede de raciocinar direito. Fico ansioso, somente pensando em terminar logo, pois tem alguém esperando apressadamente e o sucesso do negócio dos meus clientes depende disso. As pessoas querem entrega urgente, porém me culpam quando um _bug_ aparece em produção. E ainda se sentem no direito de me repreender. Mas eu avisei para eles que isso iria acontecer.


Veja que as consequências negativas do débito técnico não influenciam somente as funcionalidades de um software, elas vão muito além. Sempre existem três prejudicados pelo débito técnico:

<!-- more -->

**O dono do negócio**: um _bug_ pode representar menos vendas e diminuição da confiança do consumidor em relação ao produto;

**O cliente**: um _bug_ pode impedir que o cliente consume a sua intenção; por exemplo, ele pode não conseguir comprar uma passagem aérea pelo site da companhia;

**O desenvolvedor**: um _bug_ em produção faz com que o desenvolvedor se sinta um profissional ruim. No final das contas, mesmo que a decisão de fazer tudo às pressas não tenha sido dele, ele se sente mal.

E, o pior acontece quando não temos permissão para melhorar o código ruim. Aqui começa o ciclo de desgaste, que descrevo a seguir.


### Ciclo do desgaste


1. Em algum momento no projeto, temos que desenvolver com muita pressa, porque o produto já foi vendido e o prazo está acabando (ou porque alguma pessoa saiu do time e temos que fazer o trabalho dela no mesmo prazo, ou porque existem outros produtos que ainda nem começaram, ou por qualquer outro motivo. Na verdade, o motivo não importa, sempre haverá um motivo para a pressa). Fazemos, então, tudo sem testes, sem estudo suficiente e sem aplicar as melhores técnicas de orientação a objeto, o que requer tempo. Aceitamos fazer trabalho sujo, mas só dessa vez.

2. Antes de ir para a produção, ficamos ansiosos, porque sabemos do risco de algo dar errado.

3. O bug acontece, e aí começa a correria para corrigir e fazer o deploy. Aqui, muitos de nós começam a apelar para as suas respectivas supertições, para que tudo dê certo. É aqui que alguns desenvolvedores viram a noite fazendo correções emergenciais.

4. Ao final desse ciclo de entrega, fazemos uma retrospectiva e decidimos que essa correria não pode continuar a acontecer. Mas no mês seguinte...


### Os custos emocionais


Esses acontecimentos sucessivos vão acabando com a nossa saúde. A ansiedade que sentimos nas três primeiras fases do ciclo do desgaste é horrível. Todos sentimos essa ansiedade, é só prestar atenção a si mesmo para achá-la rondando por lá. Dia após dia, o nosso estresse aumenta. Vamos para casa pensando nos problemas e no que pode acontecer se algo der errado. A curto prazo, a nossa paciência e bom humor são prejudicados; a longo prazo, isso pode se transformar em uma doença séria. Na verdade, ansiedade e estresse já são doenças. Alguns [sintomas da ansiedade](http://veja.abril.com.br/noticia/saude/ansiedade-nao-tem-cura-mas-tem-tratamento#tabs) são raiva, fadiga, taquicardia, sudorese, dores musculares, insônia, necessidade de movimentar as partes do corpo ou fazer ruídos (manias, tiques), dificuldade em coordenar as ideias.


### A solução


Esse tipo de débito - intencional e sem data para resolução - nunca deve ser aceito, pois é um abuso e prejudica a saúde dos envolvidos. Se você é um profissional que se preze, não aceite fazer isso por tempo indeterminado. Pondere as consequências do débito e estabeleça prazos para ele ser quitado. Caso nunca seja possível corrigir os problemas, simplesmente troque de emprego, porque isso é errado e já tem muita empresa fazendo de um jeito aceitável.

A meu ver, o sucesso não reside em ganhar mais dinheiro e fama, mas sim em levar uma vida equilibrada, com bons resultados profissionais, na saúde e na família. Não aceitar esse tipo de abuso é o primeiro passo para o sucesso equilibrado.
