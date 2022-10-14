package Edit.EducacionIT14Sep2022;

import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Laboratorio6a {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EducacionIT14Sep2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	String evidenciasPath = "..\\EducacionIT14Sep2022\\Evidencias\\";	
	String nombreDocumento = "Evidencias - AutomationPractice.docx";
	File pantalla;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
			
		driver = new ChromeDriver();
		driver.get(url);
	}
		
	@Test(priority=1,description="CP01 - Ir a Contáctanos")
	public void irAContactUs() throws InvalidFormatException, IOException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(evidenciasPath + nombreDocumento, "Documento de Evidencias de Prueba - AutomationPractice", 20);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasPath + "img.jpg", evidenciasPath + nombreDocumento, "Pantalla Inicial");
		
		driver.findElement(By.linkText("Contact us")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasPath + "img.jpg", evidenciasPath + nombreDocumento, "Formulario de Contacto");
		
		Select lista = new Select(driver.findElement(By.id("id_contact")));
		lista.selectByVisibleText("Webmaster"); // Subject Heading
		
		driver.findElement(By.name("from")).sendKeys("correo28sep2022@mailinator.com");
		driver.findElement(By.cssSelector("#id_order")).sendKeys("123ABC");
			
		// Campo para subir un archivo (NUEVO)
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\addIntegerData.txt");
			
		driver.findElement(By.tagName("textarea")).sendKeys("Mensaje de Contacto");
			
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasPath + "img.jpg", evidenciasPath + nombreDocumento, "Formulario lleno");
		
		driver.findElement(By.id("submitMessage")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasPath + "img.jpg", evidenciasPath + nombreDocumento, "Resultado Final luego de enviar el formulario");
	}
		
	@Test(priority=2,description="CP02 - Buscar Palabra")
	public void buscarPalabra() throws IOException {
		// Captura de Pantalla		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(evidenciasPath + "01_pantalla_inicial.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(evidenciasPath + "02_palabra_a_buscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(evidenciasPath + "03_resultado_busqueda.jpg"));
			
		// Validación post-ejecucion
		String resultadoEsperado = "Search - My Store";
		String resultadoObtenido = driver.getTitle(); // Obtener el titulo de la pagina
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
	}
		
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
}
