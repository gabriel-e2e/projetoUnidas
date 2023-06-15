package elementos;

import org.openqa.selenium.By;

public class Elementos {

	
	public By localRetirada = By.name("storeField");
	public By loja = By.xpath("//*[contains(text(),'Barueri')]");
	public By dataRetirada = By.xpath("//span[@class='day-box ng-star-inserted' and contains(text(),20)][1]");
	public By horaRetirada = By.id("7:45");
	public By dataDevol = By.xpath("//span[@class='day-box ng-star-inserted' and contains(text(),23)][1]");
	public By horaDevol = By.id("9:45");
	public By btnAlugar = By.xpath("//a[@class='primary-button']");
	public By grupoCar = By.xpath("//span[@class='label'][1]");
	public By resumoReserva = By.xpath("//h1[contains(text(), 'Resumo da reserva')]");
	public By btnAvancarResumo = By.xpath("//div[@class='resume-action ng-star-inserted']");
	public By finalizeReserva = By.xpath("//h1[contains(text(), 'Confira e finalize sua reserva')]");
}
