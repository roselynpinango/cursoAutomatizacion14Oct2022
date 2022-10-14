package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;

public class Laboratorio9b {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EducacionIT14Sep2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		driver = new ChromeDriver(options);
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("jean");
		inicio.hacerBusqueda();
	}
}
