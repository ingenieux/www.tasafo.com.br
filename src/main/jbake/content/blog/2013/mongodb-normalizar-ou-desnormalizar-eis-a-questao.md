status=published
date=2013-09-05
tags=blog
type=post
title=MongoDB - Normalizar ou Desnormalizar, eis a questão
~~~~~~
No MongoDB, dados utilizados por múltiplos documentos podem ser embutidos (_embedded_) ou referenciados. Quando embutimos um documento em outro, temos dados desnormalizados. Quando referenciamos documentos, temos dados normalizados. Mas quando devemos escolher um ou outro? E qual os seus efeitos no design do banco de dados?

A desnormalização pode gerar dados inconsistentes. Imagine que em um documento **food**, você queira mudar o nome de **maçã** para **pêra**.  Você modifica o nome de um documento, mas a aplicação dá _crash _antes de atualizar os demais documentos. Você terá dois diferentes valores para frutas em seu banco de dados.

[code language="javascript"]
Documento Food:

{
  _id: x,
  fruit: pear
}

Coleção Meals:

[
  {
    _id: y,
    fruit: apple
  },
  {
    _id: z,
    fruit: apple
  }
]
[/code]

Para a maioria das aplicações, inconsistência pode ser ruim, mas para algumas, um breve período de inconsistência pode ser ok.  Se a aplicação não deve possuir inconsistência, a normalização é o mais aconselhável. No entanto, normalizar significa uma query extra todo tempo que for necessário fazer uma busca por uma fruta. Se sua aplicação precisa de alta performance, você terá que conviver com dados inconsistentes.

Muitas aplicações usam mais leitura do que escrita. Se determinados documentos possuem dados referenciados que mudam com uma frequência baixa, por exemplo, datas de nascimento, endereços, logs, esse pode ser um bom argumento para o uso da desnormalização. Você pode estar pagando um preço alto por cada leitura na base de dados para garantir consistência de dados que mudam raramente.

A normalização pode garantir consistência e nos dá outras facilidades. Quando estamos utilizando ferramentas ODM (Object-Document-Mapper), como [Mongoid](http://mongoid.org/en/mongoid/index.html), o código fica bem mais simples, já que a desnormalização pode nos trazer uma certa complexidade no código e na administração do banco. Para algumas aplicações seria bem complicado de conciliar insconsistência de dados.

Para sistemas que necessitam da mais alta performance possível, como sistemas de tempo real, a desnormalização é mais indicada. Nesse tipo de aplicação não há muito o que se pensar sobre isso. Real-time apps, normalmente, devem ser desnormalizados o tanto quanto possível.
