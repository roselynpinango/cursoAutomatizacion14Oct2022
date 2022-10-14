package Edit.EducacionIT14Sep2022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Laboratorio5 {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EducacionIT14Sep2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test(priority=1,description="CP01 - Ir a Contáctanos")
	public void irAContactUs() {
		driver.findElement(By.linkText("Contact us")).click();
		
		Select lista = new Select(driver.findElement(By.id("id_contact")));
		lista.selectByVisibleText("Webmaster"); // Subject Heading
		
		driver.findElement(By.name("from")).sendKeys("correo28sep2022@mailinator.com");
		driver.findElement(By.cssSelector("#id_order")).sendKeys("123ABC");
		
		// Campo para subir un archivo (NUEVO)
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Mensaje de Contacto");
		
		driver.findElement(By.id("submitMessage")).click();
	}
	
	@Test(priority=2,description="CP02 - Buscar Palabra")
	public void buscarPalabra() {	
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Validación post-ejecucion
		String resultadoEsperado = "Search - My Store";
		String resultadoObtenido = driver.getTitle(); // Obtener el titulo de la pagina
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
		//Assert.assertNotEquals(2,3);
		//Assert.assertTrue(true);
		//Assert.assertFalse(false);
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
}
