package Edit.EducacionIT14Sep2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;

public class Ejemplo_WebDriverManager {
	String url = "http://automationpractice.com";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("dress");
		inicio.hacerBusqueda();
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
}
