#language:pt
#Author: Vinicius Marra Santos

@departamento
Funcionalidade: testes referentes a chamadas de serviço da API de clientes

  @listaClientes @Chrome
  Cenario: pega lista de clientes
    Dado que eu acesse a API "http://localhost:8083"
    Quando eu consulto a lista de clientes
    Entao devo apresentar a lista de clientes cadastrados no sistema
    E o status code deve ser "200"

  @addCliente @Chrome
  Cenario: adiciona um novo cliente
    Dado que eu acesse a API "http://localhost:8083"
    Quando eu insiro um cliente com o Nome "Teste add cliente"
    Entao o status code deve ser "201"