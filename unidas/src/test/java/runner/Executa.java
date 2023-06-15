package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

import drivers.DriversFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "steps",
		tags = "@regressao",
		monochrome = true,
		dryRun = false,
		plugin = {"pretty","html:target/cucumber-report.html"},
		snippets = SnippetType.CAMELCASE
		)

public class Executa extends DriversFactory{

public static void iniciarTeste() {

		
		System.setProperty("webdriver.http.factory","jdk-http-client");
		driver = new ChromeDriver();
		driver.get("https://www.unidas.com.br");
		driver.manage().window().maximize();
	}

}
