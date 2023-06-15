#Author: gabriel.sbrissa.nunes@gmail.com

@regressao
Feature: Simular uma reserva de veículo
  Como usuário quero simular uma reserva de um veículo para obter informações de reserva

  	@positivo
  Scenario: Realizar reserva com devolucao na mesma loja
    Given que esteja na pagina unidas.com
    And informo dados de retirada
    When clico em avancar
    And escolho um grupo de carro
    Then valido a pagina resumo de minha reserva
    
   @negativo
  Scenario: Realizar reserva com dados em branco
    Given que esteja na pagina unidas.com
    And nao informo dados de retirada
    When clico em alugar
    And sistema nao deve avancar para proxima pagina
    Then valido a home page do site
    
    
    
    
    
    
   

  
