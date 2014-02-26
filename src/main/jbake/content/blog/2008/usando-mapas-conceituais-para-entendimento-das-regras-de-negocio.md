status=published
date=2008-11-24
tags=blog
type=post
title=Usando mapas conceituais para entendimento das regras de negócio
~~~~~~
Resumo
Gostaria de apresentar aqui uma prática que me ajudou muito no início de um projeto de software com um nível de conhecimento científico alto. Esse projeto ainda está em andamento, e hoje – depois de um ano – eu posso ver o quanto a adoção dos mapas conceituais me ajudou a entender as regras de negócio e a estabelecer o escopo do sistema e posteriormente o detalhamento das suas funcionalidades.

Desafios
Quando eu entrei no projeto, me deparei com um desafio: criar um software a partir das melhores práticas de zootecnia, estudadas e comprovadas durante anos por especialistas e que agora deveriam ser estruturadas para desenvolver um produto que trouxesse ao produtor rural todo esse conhecimento de forma acessível e que fornecesse benefícios práticos para o seu negócio.

Para isso eu contava – e ainda conto – com uma equipe de especialistas que me dão suporte para esse desenvolvimento. Então eu pensei: “beleza, tenho várias pessoas que sabem tudo sobre o assunto, então construir o sistema vai ser fácil”. Mas peraí, quem vai desenvolver sou eu! Eu preciso conhecer o assunto para poder estruturar o sistema, construir a lógica executada por trás de todas as tarefas e decisões que o sistema deve tomar. Além do mais, cada especialista tem conhecimento construído durante anos sobre um determinado assunto. O que eu realmente devo aprender? Qual parte desse conhecimento deverá entrar no sistema? É preciso filtrar as informações e para isso eu preciso entender como funciona o negócio.

Para responder a essas perguntas e entender como funciona o negócio, eu adotei os [mapas conceituais](http://pt.wikipedia.org/wiki/Mapa_conceitual), que me foram apresentados ainda na graduação pela minha amiga e mentora Silvana Rossy. Um mapa conceitual é uma representação do conhecimento utilizada para diversos fins, mais popularmente para potencializar o ensino e aprendizado. Através dos mapas podemos organizar nosso conhecimento. Isso é feito através de conceitos conectados por palavras de ligação, formando uma proposição. Existe muito assunto para se falar sobre mapas conceituais que não cabem a este artigo. Uma interessante representação do que são mapas conceituais pode ser encontrada [no site do Cmap Tools](http://cmapskm.ihmc.us/servlet/SBReadResourceServlet?rid=1064009710027_1483270340_27090&partName=htmltext), onde eles utilizaram um mapa conceitual para explicar o conceito do próprio mapa conceitual.

Ferramenta
Não é necessário nenhuma ferramenta para criar mapas conceituais, bastam lápis e papel. Porém o uso de uma ferramenta ajuda muito para fins de documentação e modelagem junto aos stakeholders. A ferramenta que eu uso é o [Cmap Tools](http://cmap.ihmc.us/). Ela é fácil de usar e bem prática, permite que várias pessoas modifiquem os mapas remotamente, exporta os mapas para diferentes formatos e os disponibiliza na internet.

Utilizando os mapas conceituais para entender o negócio
A princípio eu li alguns livros e artigos sobre zootecnia de forma geral, para começar a criar alguma coisa. Escrevi minhas primeiras proposições, para então discuti-las separadamente com cada especialista, cada um responsável por uma área do negócio.

Várias reuniões aconteceram, e durante cada uma delas os mapas aumentavam, se modificavam, dúvidas iam surgindo e outras eram solucionadas. O interessante dos mapas conceituais é que através deles é possível construir conhecimento de forma fácil e divertida. Tudo o que eu fiz foi criar alguns pequenos mapas no início. A partir das reuniões, eles cresceram colaborativamente e naturalmente.

É muito difícil abordar um assunto desconhecido para alguém com uma pessoa que sabe muito sobre ele. Como explicar para ela o que eu quero saber? Se deixar, a pessoa fala durante meses sobre aquilo. Os mapas realizam perfeitamente essa tarefa. Foram tantas as vezes que eu entreguei um pequeno mapa para um especialista e ele começou a complementá-lo instintivamente. Cada proposição nova gerava uma conversa e outras proposições surgiam facilmente. No final eu tinha algo parecido com isso:

[caption id="attachment_26" align="alignnone" width="450" caption="Mapa conceitual do manejo alimentar"][![Mapa conceitual do manejo alimentar](http://tasafo.files.wordpress.com/2008/11/manejo-alimentar.jpg)](http://tasafo.files.wordpress.com/2008/11/manejo-alimentar.jpg)[/caption]

É engraçado como diferentes formas de abordar um assunto podem fazer com que o conhecimento se desenvolva de formas tão variadas. Os mapas conceituais me permitiram entender uma área grande de forma rápida e surpreendente; permitiram orgazinar, representar e compartilhar conhecimento.

Além de tudo isso os mapas são úteis para a especificação de requisitos. Através deles é possível delimitar o escopo e definir quais atividades devem compor o sistema. Foi a partir dos meus mapas conceituais que eu escrevi os casos de uso que usei para detalhar cada atividade.

Conclusão
Utilizar mapas conceituais como auxílio ao entendimento das regras de negócio é uma ótima prática que eu recomendo sempre que um projeto de software abordar um assunto de difícil entendimento e/ou com altos níveis de conhecimento científico agregado. Eles ajudam a criar uma ponte entre as pessoas que detêm conhecimento e os desenvolvedores, guiando as reuniões, através de uma linguagem de fácil entendimento e que não necessida de conhecimentos de informática para ser aplicada e entendida.

Peço que, se alguém utilizar os mapas conceituais do jeito que descrevi ou de qualquer outra forma que beneficie um projeto de desenvolvimento de software, poste um comentário ou me mande um e-mail contando como foi a experiência.

Obs: post publicado originalmente no meu [blog](http://jaimesch.blogspot.com/).
