#language:pt
#Author: Vinicius Marra Santos

@Cadastro
Funcionalidade: testes referentes a chamadas de serviço da API de Cadastro

  @listaCadastro
  Cenario: pega lista de cadastros realizados no sistema e valida se não é null
    Dado que eu acesse a API "http://pet-backend:8080"
    Quando eu consulto a lista de clientes
    Entao devo apresentar a lista de clientes cadastrados no sistema
    E o status code deve ser "200"

  @addCliente
  Cenario: adiciona um novo cadastro na aplicação
    Dado que eu acesse a API "http://pet-backend:8080"
    Quando eu insiro um cadastro novo
    Entao o status code do cadastro deve ser "201"
