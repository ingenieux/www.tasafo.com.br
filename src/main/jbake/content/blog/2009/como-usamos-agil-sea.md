status=published
date=2009-11-05
tags=blog
type=post
title=Como usamos Ágil: SEA
~~~~~~
Dando continuidade à série “Como usamos Ágil”, entrevistei o trio Alexandre Gomes, Bruno Pedroso e Renato Willi, da [SEA Tecnologia](http://www.seatecnologia.com.br/). Nesta entrevista eles falam sobre a cultura da SEA e como lidam com o difícil mercado de licitações.

**TaSafo**: Quais metodologias ágeis são utilizadas na SEA?

**SEA**: Não abraçamos uma metodologia por completo. Utilizamos Scrum e XP como base para o nosso jeito de desenvolver software. Utilizamos conceitos de Scrum para planejamento e temos práticas do XP como testes automáticos, integração contínua, programação em par, entre outras. Na verdade damos muito mais ênfase aos valores. É como se disséssemos aos desenvolvedores: "sigam esses valores e façam do jeito que acharem melhor".

**TaSafo**: Em relação ao Scrum, qual o tempo de uma _sprint_?

**SEA**: O tempo da _sprint_ varia de projeto para projeto, mas costuma ser de 2 semanas a 1 mês. Esse tempo depende do cliente e da equipe. Em relação à equipe, geralmente usamos _sprints_ mais curtas quando temos uma equipe menos experiente.





**TaSafo**: Após definir o tempo da sprint de um projeto, esse tempo permanece o mesmo até o final?





**SEA**: Depende. Sabemos que o ideal é que se mantenha, mas já houve casos em que mudamos. Em um projeto passamos a _sprint_ de 2 semanas para 1 mês, pois a equipe pegou experiência e as reuniões a cada 2 semanas estavam gerando _overhead_ da gerência. O impacto não foi muito grande, pois já gerávamos uma _build_ semanal e aferíamos a velocidade semanalmente.







**TaSafo**: Como são feitos os contratos entre a empresa e os clientes? Vocês usam contrato de escopo negociável?







**SEA**: Em contratos com o governo, todos os projetos são de escopo fechado, e trabalhamos com métricas. Com a iniciativa privada, metade são de escopo negociável, metade com métricas.







**TaSafo**: Em ambos os casos, como funcionam as estimativas do projeto?

**SEA**: Nós temos coletado métricas dos nossos projetos há dois ou três anos e aprendemos a usá-las para nos auxiliar nas estimativas. Por exemplo, nós temos uma boa estimativa do intervalo de tempo necessário para desenvolver um ponto de função. Para isso, levamos em consideração principalmente a complexidade do sistema e a equipe de desenvolvimento. Então usamos pontos de função e pontos por caso de uso para nos auxiliar nos projetos de escopo fechado (um exemplo de como essas métricas são usadas pode ser encontrado no [blog da SEA](http://blog.seatecnologia.com.br/2009/05/11/como-medimos-sistemas-em-pontos-de-casos-de-uso)).

Quando temos escopo aberto, fazemos uma estimativa de alto nível, geralmente usando um intervalo de tempo de 1, 2 ou 3 semanas. Se a estimativa passar de 3 semanas, quebramos a funcionalidade e estimamos novamente. Dessa forma temos uma estimativa grosseira do projeto inteiro.







De qualquer forma, sempre procuramos mesclar várias técnicas para estimar. A convergência (ou não) das estimativas, dá noção do risco do projeto.

<div id="attachment_474" class="wp-caption" align="aligncenter" style="width: 408px"><p class="wp-caption-text"></p></div>
![Cooperação e sucesso mesmo com escopo fechado com o governo](http://tasafo.files.wordpress.com/2009/11/sea-reuniao.jpg?w=1024) Cooperação e sucesso mesmo com escopo fechado

<!-- more -->**TaSafo**: Quem é o _product owner_ (PO) e como ele age?

**SEA**: Existe um PO, que pode ser um membro da equipe sempre em contato com o cliente, ou o cliente em si, que é o melhor cenário. Na maioria das vezes a nossa equipe inteira fica alocada no cliente. Nesses casos, temos o cliente relativamente presente. Quando isso não acontece, tentamos manter um mínimo de contato com o PO. A medida que ele percebe o retorno dessa presença, podemos melhorar a frequência.




**TaSafo**: Isso (quando o PO não está sempre presente) tem influência as estimativas?




**SEA**: Sim, de forma negativa. Quanto mais longe, pior. Nesse caso, se a equipe não está em contato direto com o PO, naturalmente o conhecimento sobre o sistema e o _feedback_ do cliente diminui, e as estimativas sofrem com isso.







**TaSafo**: Existem várias equipes trabalhando simultaneamente? Quantas pessoas cada equipe possui?







**SEA**: Hoje temos 10 projetos simultâneos, divididos em 7 equipes. Tem uma equipe que chamamos de PPTO (pau pra toda obra), que atende demandas pontuais, pois temos projetos que não têm demanda contínua, nos quais recebemos uma ordem de serviço (para criar uma funcionalidade nova, por exemplo), executamos e passamos para a próxima. Nós tentamos fazer com que uma equipe fique 100% focada em um só projeto, para evitar o problema de multitarefa.

Em relação ao tamanho das equipes, temos equipes de 2 a 6 pessoas. Eu (Renato) e o Bruno estamos em todas e em nenhuma, pois não ficamos alocados o tempo todo em uma só equipe. Fazemos mais os papéis de coordenador e _coach_. Entramos e saímos das equipes de acordo com as necessidades. Por exemplo, na equipe da aeronáutica nós quase não interferimos mais, pois estão maduros o suficiente para caminhar sozinhos. Então voltamos nossa atenção para outros projetos, novas vendas e novas negociações.


![](http://tasafo.files.wordpress.com/2009/11/sea-dashboard.jpg?w=1024)


**TaSafo**: Como é o ambiente físico de trabalho?** **

**SEA**: Isso varia muito. Nos clientes sempre tentamos fazer com que a equipe fique na mesma sala, sem baias nem paredes, e que tenha espaço para 2 pessoas dividirem 1 computador. Na verdade preferimos a relação 2 pessoas x 1 computador. Já na SEA temos uma mesona e todo mundo senta ao redor dela. É só chegar com o seu _notebook_ e trabalhar.



**TaSafo**: Existe algum aspecto que marca seu método? Algum toque especial fora do padrão das metodologias?

**SEA**: Não que seja algo inovador ou fora do padrão, pois as metodologias são muito extensíveis, mas uma coisa que fizemos e chamou atenção de algumas pessoas da comunidade foi o uso do que apelidamos de "mantras". Durante as retrospectivas, surgiam algumas fraquezas que não conseguíamos endereçar com ações pra serem melhoradas nas próximas iterações, pois faziam parte de hábitos ou disciplinas que a equipe deveria se atentar mais o tempo todo, como padrão do código, comitar, completar o javadoc, etc.

Para as equipes ficarem atentas a essas questões, escolhíamos uns 3 hábitos desses para serem observados na iteração, fazíamos frases tipo mantras, por exemplo: "eu documentarei mais o código", ou "eu seguirei o padrão tal", as anotávamos grandes num papel e deixávamos no topo do Kanban. Brincávamos que todo dia cada um tinha que chegar cedo e ficar repetindo essas frases na frente do Kanban algumas vezes pra não esquecer. Era uma brincadeira, claro que ninguém ficava repetindo as frases rezando na frente do Kanban, mas essas questões iam melhorando ao longo das iterações.





**TaSafo**: Qual é o profissional que a SEA procura?





**SEA**: Essa é uma pergunta boa. O pessoal às vezes pergunta: "tem que ser gente boa para trabalhar com metodologia ágil? Tem que ser profissional sênior, muito experiente?". A pessoa tem que ser boa sim, mas o que é ser gente boa para gente?

Eu acho que o bom profissional não é necessariamente uma pessoa com anos de experiência e todas as certificações possíveis e imaginárias. Às vezes isso até atrapalha devido ao alto comprometimento que a pessoa tem com o passado de sua carreira que leva à resistência a mudanças. Temos procurado pessoas curiosas, motivadas, que gostem do que fazem e que tenham iniciativa. É nossa leitura para o "safo" que usamos tanto para descrevê-los. Uma pessoa assim, se não tiver um determinado conhecimento numa tecnologia ou ferramenta, o adquire facilmente. Experiência é trocada com os mais experientes. Quando a pessoa vem para SEA, vem como um todo, não só para um papel ou para trabalhar num determinado projeto ou tecnologia. Queremos que ela desenvolva todo seu potencial na empresa, e sempre damos chance pra isso. Esse talvez seja um dos grandes chamarizes pra eles.


<div id="attachment_473" class="wp-caption" align="aligncenter" style="width: 422px"><p class="wp-caption-text"></p></div>
![Ambiente de trabalho na sede da SEA](http://tasafo.files.wordpress.com/2009/11/sea-equipe-2.jpg?w=1024) Ambiente de trabalho na sede da SEA

_Uma curiosidade: a SEA surgiu como uma parceira da Rational e era especializada em implantação da metodologia de desenvolvimento RUP. Mesmo contando com equipes qualificadas e depois da tentativa de implantação de modelos de qualidade de processos como o MPS.BR, a empresa alcançou melhores resultados em termos de estabilidade, satisfação, sustentabilidade e rotatividade depois de adotar as metodologias ágeis, há dois anos._
