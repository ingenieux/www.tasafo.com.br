---
author: felipeiketani
comments: true
date: 2012-05-25 17:37:24+00:00
layout: post
slug: seu-projeto-nao-tem-testes-pior-pra-ele
title: Seu projeto não tem testes? Pior pra ele
wordpress_id: 2754
categories:
- Artigos
- técnico
tags:
- design
- tdd
- testes
---

Olá pessoal! Esse é o meu segundo post aqui no blog do Tá Safo! e desta vez vou falar sobre testes e TDD que é um tema ainda pouco discutido pela região.

Bem, eu vejo em muitos lugares, inclusive em gerências de projetos por ai que uma tarefa é dividida nos seguintes estágios: A Fazer, Fazendo, Testando, Homologação e Pronto.

A primeira é quando a funcionalidade ainda está a espera de ser implementada, a segunda é quando alguma criatura começa a produzir a tarefa (que no nosso caso, é o código). Então, após ser implementado ele será testado para depois ser aceito pelo cliente e pronto, fim de papo.

Sempre que assisto a alguma palestra ou converso com alguém sobre o que este teste realmente quer dizer, ouço que é alguém dedicado a usar o software para saber se a funcionalidade feita está de acordo com o esperado e/ou funcionando.

Cruzes! Toda vez que escuto isso me dá um frio na espinha, sério. Primeiramente, existe uma pessoa dedicada para isso. Segundo, o teste é feito manualmente. Terceiro, o teste é feito DEPOIS que o código é escrito.

Óbvio, hehe, o terceiro ponto pareceu muito esquisito. Não tem como testar a função antes dela ter sido implementada. Quebremos, então, este paradigma.

<!-- more -->

Apresento-lhe os testes automatizados. Você, desenvolvedor, escreve um teste que valida algum código em produção. Este teste deve rodar automaticamente com uma única linha de comando ou um clique de um botão e deve sempre passar após ele ser implementado.

Perceba que você escreverá 2 vezes mais código (mentira, serão 4 vezes mais código). Sim, é verdade, e este é uma das inúmeras quebras de paradigmas que você precisará passar.

Imagine que todo o seu código foi testado, todos os testes estão passando e você verifica que todo o software está funcionando como esperado em segundos! Qualquer desenvolvedor, "testador", analista, quem seja, poderá rodar os testes.

Perceba também que não existe mais um papel separado para o testador, o desenvolvedor já é o testador do código. O caso é que somente testar o código e faze-lo passar não é o suficiente para trazer segurança no seu código.

É ai que vem o TDD (Test Driven Development) que significa Desenvolvimento Dirigido a Testes. Nele existem três regras básicas:

1. Você não tem permissão de escrever qualquer código de producão a menos que seja para fazer um teste passar.

2. Você não tem permissão de escrever mais nenhum teste que o suficiente para falhar.

3. Você não tem permissão de escrever mais nenhum código de produção do que o suficiente par afazer o teste passar.

[ [http://butunclebob.com/ArticleS.UncleBob.TheThreeRulesOfTdd](http://butunclebob.com/ArticleS.UncleBob.TheThreeRulesOfTdd) ]

As três regras resultam em algo mais resumido que é o chamado ciclo Red Green Refactor (Vermelho Verde Refatorar). Isso significa que você deve primeiro, sempre, escrever um teste que falha (Vermelho) para então escrever código de produção que faça o teste passar (Verde) e com ele passando, refatore o código para que ele fique limpo e mais fácil de entender.

Se você seguir estas regras, seu código terá sempre 100% de cobertura e no momento que o cliente pedir uma alteração em uma funcionalidade, você poderá saber onde a alteração quebrou código em qualquer lugar do projeto!

Você não terá mais aquele medo enorme ao mudar o código, pois você saberá exatamente onde modificar para que o software funcione sempre como esperado!

Lembre-se dos princípios ágeis onde a mudança é algo esperado e mudar o mais rápido possível, com código funcionando, é um dos maiores princípios que a agilidade nos traz.

Depois desta introdução, eu tentarei mostrar mais tecnicamente como criar testes automatizados e o ciclo do TDD em futuros artigos aqui no TÁ Safo!, então fique ligado!

Além disso, eu tenho um [Lightning Talk](http://call4paperz.com/events/t%C3%A1-safo-conf-lightning-talks) no [Tá Safo Conf 2012](http://tasafo.org/conf2012) que mostrarei exatamente como trabalho com TDD no trabalho e rodarei os testes ao vivo para vocês verem como é maneiro! Não deixe de votar no meu talk e também de se inscrever no evento! O tempo está correndo!
