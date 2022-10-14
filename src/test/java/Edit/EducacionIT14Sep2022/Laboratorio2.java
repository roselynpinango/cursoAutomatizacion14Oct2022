package Edit.EducacionIT14Sep2022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2 {
	// Definición de variables que vamos a utilizar
	String url = "http://automationpractice.com";
	String chromeDriverPath = "..\\EducacionIT14Sep2022\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\EducacionIT14Sep2022\\Drivers\\geckodriver.exe";
	
	// Métodos de Prueba (acciones para probar un sistema web)
	@Test
	public void hacerBusquedaChrome() {
		// Paso 1: Indicar dónde está el archivo driver.exe
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		// Paso 2: Indicar qué navegador vamos a usar
		WebDriver navegador = new ChromeDriver(); 
		
		// Paso 3: Abrir la página que queremos probar
		navegador.get(url);
		
		// Paso 4: Escribir la palabra que queremos buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 5: Simular que presionamos la tecla ENTER
		txtBuscador.sendKeys(Keys.ENTER);
		
		System.out.println("Título: " + navegador.getTitle());
		System.out.println("URL: " + navegador.getCurrentUrl());
	}
	
	@Test
	public void hacerBusquedaFirefox() {
		// Paso 1: Indicar dónde está el archivo driver.exe
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		// Paso 2: Indicar qué navegador vamos a usar
		WebDriver navegador = new FirefoxDriver(); 
		
		// Paso 3: Abrir la página que queremos probar
		navegador.get(url);
		
		// Paso 4: Escribir la palabra que queremos buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 5: Simular que presionamos la tecla ENTER
		txtBuscador.sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Search - My Store"));
		
		System.out.println("Título: " + navegador.getTitle());
		System.out.println("URL: " + navegador.getCurrentUrl());
	}
}
