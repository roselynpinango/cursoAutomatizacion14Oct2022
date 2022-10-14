package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaContactUs;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratoio7Test {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT14Sep2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo0510@gmail.com");
		login.escribirPassword("7u6y5t4r3e");
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("dress");
		inicio.hacerBusqueda();
	}
	
	@Test
	public void irAContactUs() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnContactUs();
		
		PaginaContactUs contacto = new PaginaContactUs(driver);
		contacto.seleccionarSubject("Webmaster");
		contacto.escribirEmail("correo0510@gmail.com");
		contacto.escribirOrderId("445B");
		contacto.adjuntarAdrchivo("C:\\addIntegerData.txt");
		contacto.escribirMessage("Mensaje de Contacto");
		contacto.hacerClicEnSend();
	}
	
	@AfterSuite
	public void cerrarPagina() {
		//driver.close();
	}
}
