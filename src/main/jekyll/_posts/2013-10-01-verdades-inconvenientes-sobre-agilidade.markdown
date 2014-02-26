---
author: paulociecomp
comments: true
date: 2013-10-01 13:19:40+00:00
layout: post
slug: verdades-inconvenientes-sobre-agilidade
title: Verdades inconvenientes sobre agilidade
wordpress_id: 3508
categories:
- Artigos
- TáSafo em Ação
- técnico
tags:
- agile
---

O desenvolvimento ágil vem ganhando força nos últimos anos, tornando-se uma febre. Papéis como Scrum Master, estão cada vez mais recorrentes nos currículos de profissionais de TI, muitas vezes, em tentativas oportunistas de aproveitar a febre do momento. Isso não é errado, mas tem um lado muito ruim, o da não compreensão do que é agilidade. Eu, particularmente não gosto de usar o termo agilidade, pois pra mim, só existe um meio de se desenvolver software, e é com desenvolvimento ágil. Mas algumas vezes, é necessário "dar nome aos bois".

**Disclaimer**

Esse post não reflete a opinião do Tá Safo e é de total responsabilidade do autor  :P

**Scrum não é ágil**

Scrum não é metodologia ágil. Scrum é um processo para gestão e controle. Não é a toa que gerentes adoram. E como todo _framework_ que se preze, possui alguns padrões embutidos em si. Ele implementa alguns conceitos ágeis, mas não é porque possui um processo interativo, que será ágil.

Não sou contra o Scrum. Na verdade acho uma ferramenta fantástica para equipes que estão começando no desenvolvimento ágil. E, uma evolução disso seria abandonar o Scrum à medida que a equipe evolui. Equipes mais experientes em agilidade não irão tolerar o Scrum por muito tempo. É preferível seguir os princípios e valores ágeis do que um processo _by the book_.

Também não curto papéis como Scrum Master e Product Owner. Se existe a grande necessidade de um Scrum Master, talvez a gestão da empresa não seja tão boa, pois é necessário um papel para proteger o time da burocracia. O PO é um papel, que sinceramente não sei pra que serve. O stakeholder é mais importante, pois é este quem define o que valor ou não. O que ocorre é que, muitas vezes, o stakeholder está ausente. Agilidade é sobre valor. Se não existe stakeholder, não existe valor, logo não existe agilidade.

**Não existe agilidade sem testes automatizados**

A verdade é dura. A verdade é única. O sistema é binário. Zero ou um. Vivo ou morto. Agilidade é sobre proporcionar _feedbacks_ rápidos. Não é possível fazer isso sem uma boa cobertura de testes **automatizados**. Novamente: **automatizados**. De novo: **automatizados**. E ainda não estou falando de TDD (que por sinal, esse sim, é um método ágil). Estou falando de receber **feedbacks** rápidos sobre mudanças efetuadas no código.

Alguém pode dizer: _posso proporcionar isso sem testes automatizados. Sou foda_. Talvez, com uma base de código pequena e simples, seja possível. Mas lembrem-se que software é um sistema vivo (de acordo com o dogma máximo da ciência moderna, a teoria da evolução), ele muda e evolui com o tempo. A tendência é que ele se torne complexo. A não ser que ele só possua CRUDs, nesse caso nem é necessário um desenvolvedor.

Em 1981, Barry Boehm, em seu livro Software Engineering Economics, sugeriu que o custo de mudanças em um projeto de software cresce exponencialmente durante o desenvolvimento. Logo, seria melhor fazer a maioria das alterações necessárias logo no começo de um projeto, que seriam as fases de levantamento de requisitos e análise. Isso é método tradicional, conhecido como **cascata**.

O Extreme Programming nos dá outra alternativa. Podemos manter esse custo baixo e constante durante o ciclo de vida do software. Esse é um dos grandes benefícios do TDD. Ele nos proporciona um bom _design_ e de cara nos dá uma cobertura de testes **automatizados**. Ganhamos uma facilidade na compreensão do código, segurança para modificá-lo e uma documentação executável. Não quero mais nada na minha vida.

**A agilidade se desenvolve em torno de indivíduos motivados.**

Não consigo descrever muito bem o que é **Management 3.0**. Jurgen Appelo fez, nada mais, que pegar várias idéias e conceitos bons que existiam soltos por aí e escreveu um livro excelente. Esse modelo de gestão que ele criou, chamada de **Gestão 3.0** ou **Gestão Ágil**, trabalha com seis visões: **energizar pessoas, empoderar times, alinhar restrições, desenvolver competências, crescer a estrutura, melhorar tudo**.

Na minha não tão humilde opinião, este livro deveria ser leitura obrigatória para quem quiser adotar agilidade em sua organização. E se você tem preguiça de ler, existe um curso oficial sobre o tema, oferecido pela [Adaptworks](http://www.adaptworks.com.br/treinamento/Management-3-0). Enfim, por que citei isso? Porque agilidade é sobre pessoas. Se não existe um desenvolvimento de pessoas, se não existe respeito, se não existe confiança, não existe agilidade.

Quando tem ser humano no meio, o bicho pega. Não é exato. Não existem verdades. O sistema não é binário. Quando o fator humano é posto em segundo plano, não há como adotar _agile_. Horas extras, trabalhos em feriados, pontos eletrônicos, tudo isso é, na verdade, uma tremenda falta de bom senso e, porque não dizer, falta de **respeito**. Empresas muito engessadas, departamentais, burocráticas em excesso, desorganizadas, com alta rotatividade de funcionários irão falhar miseravelmente e irão dizer que _agile_ não funciona. E isso está acontecendo neste momento.

**tl;tr**

Muitos podem dizer que o importante é entregar software, seja ágil ou não. Não acredito nisso. Não devemos entregar software a custo do sacrifício de outros fatores, como motivação, qualidade, satisfação pelo seu trabalho. No fim das contas, metodologia não desenvolve software. Engenheiros desenvolvem software. **A agilidade é inerente ao bom desenvolvedor**.

A qualidade técnica sobrepuja qualquer dogma. Desenvolvedores, talvez não precisem de controle, mas sim de liberdade, para criar, para explorar, para desenvolver sua arte. Muitas empresas já perceberam isso e estão no caminho certo.
