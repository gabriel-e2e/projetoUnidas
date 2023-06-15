package metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriversFactory;

public class Metodos extends DriversFactory {

	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);

	}

	public void scroll(int qtdScroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + qtdScroll + ")", "");

	}

	public void clicar(By elemento) {
		driver.findElement(elemento).click();
	}

	public void esperarClicar(By elemento, int qtd, int segundos) {

		WebElement elementoFechar = driver.findElement(elemento);
		elementoFechar = new WebDriverWait(driver, Duration.ofSeconds(segundos))
				.until(ExpectedConditions.elementToBeClickable(elemento));
		while (elementoFechar.isDisplayed() && qtd > 0) {
			elementoFechar.click();
			qtd--;
		}
	}

	public void submit(By elemento) {
		driver.findElement(elemento).submit();

	}

	public void limparCampp(By elemento) {
		driver.findElement(elemento).clear();
	}

	public void trocarDeAba() {

		String janelaAtual = driver.getWindowHandle();
		Set<String> janelas = driver.getWindowHandles();

		for (String janela : janelas) {
			driver.switchTo().window(janela);
			System.out.println("Endereço do site " + driver.getCurrentUrl());
		}

	}

	public void validarTexto(By elemento, String textoDesejado) {
		String textoCapturado = driver.findElement(elemento).getText();
		assertEquals(textoCapturado, textoDesejado);

	}

	public void validarUrl(String urlDesejada) {
		String urlCapturado = driver.getCurrentUrl();
		assertEquals(urlCapturado, urlDesejada);

	}

	public void fechar() {

		driver.quit();

	}

	public void esperarElemento(By elemento) {
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(elemento));

	}

	public void ptrScr(String nomeEvidencia) {

		try {
			TakesScreenshot srcShot = (TakesScreenshot) driver;
			File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./evidencias/" + nomeEvidencia + ".png");
			FileUtils.copyFile(srcFile, destFile);

		} catch (Exception e) {
			System.err.println("*******************ERROR SCREEN*************************");
			System.err.println("**" + e.getCause() + "**");

		}

	}

}