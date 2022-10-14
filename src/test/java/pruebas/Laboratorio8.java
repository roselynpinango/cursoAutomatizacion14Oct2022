package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio8 {
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
	
	@Test(dataProvider="Obtener Datos Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}

	@DataProvider(name="Obtener Datos Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT14Sep2022\\Entrada\\DataProvider12Oct2022.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Obtener Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2]; // Arreglo de 3 filas y 2 columnas
											 // Filas: cada prueba a ejecutar
											 // Columnas: cada campo requerido para la prueba
		datos[0][0] = "abc@gmail.com"; // correo
		datos[0][1] = "4t5465ey"; // contraseña
		
		datos[1][0] = "def@gmail.com";
		datos[1][1] = "8iy87i78";
		
		datos[2][0] = "ghi@gmail.com";
		datos[2][1] = "90po6tutg4w3";
		
		return datos;
	}
	
	@AfterSuite
	public void cerrarPagina() {
		//driver.close();
	}
}
