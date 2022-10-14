package pruebas;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio9 {
	String url = "https://demoqa.com/alerts";
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
	public void alertaNotificacion() {
		driver.findElement(By.id("alertButton")).click(); // Clic en el botón
		
		driver.switchTo().alert().accept(); // Clic en OK de la alerta
	}
	
	@Test
	public void alertaConDemora() {
		driver.findElement(By.cssSelector("#timerAlertButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void alertaDismiss() {
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void alertaText() {
		driver.findElement(By.id("promtButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		
		System.out.println(alerta.getText());
		
		alerta.sendKeys("Hola Clase de Automatizacion");
		alerta.accept();
	}
}
