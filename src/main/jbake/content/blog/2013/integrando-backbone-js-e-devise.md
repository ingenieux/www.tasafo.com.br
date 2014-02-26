status=published
date=2013-08-23
tags=blog
type=post
title=Integrando backbone.js e devise
~~~~~~
Imagine o seguinte cenário: queremos implementar uma autenticação de usuário em um sistema rails que utiliza o _devise_. No front-end, estamos utilizando o _backbone.js_. Não é uma tarefa das mais complicadas, mas que requer alguns artifícios e um bom conhecimento da api do _devise_.




[Devise](https://github.com/plataformatec/devise) é uma gem desenvolvida pela galera da [plataformatec](http://plataformatec.com.br/), que nos proporciona uma api completa e flexível para soluções de autenticação em rails. Sua api já abstrái para o desenvolvedor funcionalidades como encriptação senha, Omniauth, confirmação por email, esqueceu sua senha, bloqueio de conta, entre outras coisas.




O [backbone.js](http://backbonejs.org/) é uma biblioteca javascript para criação de web apps. Ele nos auxilia a trabalhar em aplicações javascript de maneira desacoplada do DOM. Com estruturas de **model**, **collections**, **views** e **templates**, nos proporciona uma melhor organização e modularização do código javascript, facilitando a compreensão e a manutenção. Chega de javascript macarrônico. Backbone trabalha nativamente com REST, logo, casa muito bem com aplicações rails, restful.




<!-- more -->




**Mão na massa**




Como vamos usar o backbone para montar a interface com o usuário, não iremos utilizar os helpers do rails e do devise para montar os formulários. Em um projeto rails já pré-configurado com o devise, vamos instalar o backbone.js. Como sou preguiçoso, vou usar a gem [banckone-on-rails](https://github.com/meleyal/backbone-on-rails).**<!-- more -->**




Criei a view user_login.js para a tela como formulário de login:



[code language="javascript"]
BackDevise.Views.UserLogin = Backbone.View.extend({
  template: JST["users/login"],

  events: {
   "submit #user_login" : "auth"
  },

  initialize: function(){
    this.user = new BackDevise.Models.User();
    this.render();
  },

  auth: function(e){
    e.preventDefault();
    var $form = $(e.target);
    var self = this;

    $.ajax({
      url: "/users/sign_in.json",
      data: $form.serialize(),
      dataType: "json",
      type: "post",
      error: function(response){
        var result = $.parseJSON(response.responseText);
        $(".box-content").prepend("<div class="alert alert-error">"+ result['error'] +"</div>");
      },
      success: function(res){
        self.user.set(res);
        new BackDevise.Views.Dashboard({user: self.user});
      }
   })
 },

 render: function(){
   $(this.el).html(this.template());
   $("#main").html(this.el);
 }
})

[/code]

Abaixo, a view do cadastro de usuário:

[code language="javascript"]
BackDevise.Views.UserRegistration = Backbone.View.extend({
  template: JST["users/signup"],

  events: {
    "submit #user_registration" : "signup"
  },

  initialize: function(){
    this.user = new BackDevise.Models.User();
    this.render();
  },

  signup: function(e){
    e.preventDefault();
    var $form = $(e.target);
    var self = this;

    $.ajax({
      url: "/users.json",
      data: $form.serialize(),
      dataType: "json",
      type: "post",
      error: function(response){
        var result = $.parseJSON(response.responseText);

        _(result.errors).each(function(errors,field) {
          var $controlGroup = $('.user_'+field);

          $('.user_'+field).addClass('error');
          _(errors).each(function(error, i) {
            $controlGroup.children(".controls").find("span.help-inline").remove();
            $controlGroup.children(".controls").append('<span class="help-inline">'+ error +'</span>');
          });
      });
    },
    success: function(res){
      self.user.set(res);
      window.location = "/";
    }
  })
 },

  render: function(){
    $(this.el).html(this.template());
  }
})
[/code]

Como pode ser notado, não utilizei os métodos do _backbone_ para fazer as requisições _ajax_. Ao invés disso, usei **jquery** puro, pois assim evitei utilizar mais uma dependência no projeto para mapear os atributos do formulário para o _model_ _user_. No entanto, é recomendável utilizar os métodos do _backbone_, como [model.save()](http://backbonejs.org/#Model-save), pois deixa o código bem mais semântico.

Pulo do gato

A partir da versão **2.2.0**, o _devise_ não aceita mais, por _default_, solicitações no formato **json**. Logo, é necessário setar o método **respond_to** no _controller_ do _devise_. Para isso, adicionamos no **application.rb** o seguinte código:

[code language="ruby"]
  config.to_prepare do
    DeviseController.respond_to :html, :json
  end

[/code]

Segue o link para o sistema: http://enigmatic-reaches-7294.herokuapp.com/

Código no github: https://github.com/paulociecomp/backbone-devise
