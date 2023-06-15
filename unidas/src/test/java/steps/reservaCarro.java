package steps;

import elementos.Elementos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.Metodos;
import runner.Executa;

public class reservaCarro {
	
	Executa executa = new Executa();
	Metodos metodos = new Metodos();
	Elementos el = new Elementos();
	
	
	@Given("que esteja na pagina unidas.com")
	public void que_esteja_na_pagina_unidas_com() {
		executa.iniciarTeste();
	   
	}

	@Given("informo dados de retirada")
	public void informo_dados_de_local_e_retirada() throws InterruptedException {
		metodos.escrever(el.localRetirada, "Barueri");
		metodos.clicar(el.loja);
		
		Thread.sleep(1000);
		metodos.clicar(el.dataRetirada);
		Thread.sleep(1000);
		metodos.clicar(el.horaRetirada);
		Thread.sleep(1000);
		metodos.clicar(el.dataDevol);
		Thread.sleep(1000);
		metodos.clicar(el.horaDevol);
		
    
	}

	@When("clico em avancar")
	public void clico_em_avancar() throws InterruptedException {
		metodos.clicar(el.btnAlugar);
		Thread.sleep(6000);
		metodos.scroll(600);
	}

	@When("escolho um grupo de carro")
	public void escolho_algum_grupo_de_carro() throws InterruptedException {
		Thread.sleep(1000);
		metodos.clicar(el.grupoCar);
	
	   
	}

	@Then("valido a pagina resumo de minha reserva")
	public void visualizo_resumo_de_minha_reserva() throws InterruptedException {
		Thread.sleep(1000);
		metodos.validarTexto(el.resumoReserva, "Resumo da reserva");
		metodos.scroll(1800);
		Thread.sleep(1000);
		metodos.clicar(el.btnAvancarResumo);
		Thread.sleep(1000);
		metodos.validarTexto(el.finalizeReserva, "Confira e finalize sua reserva");
		metodos.validarUrl("https://www.unidas.com.br/reserva/passo-4");
		metodos.ptrScr("resumoReserva");
		metodos.fechar();
	   
	}
	
	@Given("nao informo dados de retirada")
	public void nao_informo_dados_de_retirada() {
	    
	}
	
	@When("clico em alugar")
	public void clico_em_alugar() {
		metodos.clicar(el.btnAlugar);
	    
	}
	@When("sistema nao deve avancar para proxima pagina")
	public void sistema_nao_deve_avancar_para_proxima_pagina() {
	   
	}
	
	@Then("valido a home page do site")
	public void visualizo_site_nao_avancar_para_proxima_page() {
		metodos.validarUrl("https://www.unidas.com.br/");
		metodos.ptrScr("informeDados");
		metodos.fechar();
	    
	}

}
