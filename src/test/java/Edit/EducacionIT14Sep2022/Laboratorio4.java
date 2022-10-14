package Edit.EducacionIT14Sep2022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio4 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionIT14Sep2022\\Drivers\\chromedriver.exe";

	@Test
	public void registrarUsuario() {
		// Abrir el navegador en la pagina seleccionada
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url); // equivalente a driver.get(url);
		driver.manage().window().maximize(); // Maximizo la pantalla
		driver.manage().deleteAllCookies(); // Borro las cookies
		driver.navigate().refresh(); // Refrescar la página (F5)
		
		// Paso 1: Ingresar el correo y hacer clic en Create An Account
		String email = "correo" + Math.random() + "@mailinator.com";
	
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.name("SubmitCreate")).click();
		
		// Es necesaria una espera porque hay una transicion de pagina y se demora
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		// Paso 2: Completar el formulario y hacer clic en Register
		// Primera Sección: Información Personal
		driver.findElement(By.cssSelector("#id_gender1")).click(); // Radio Button "Title"
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Ernesto"); // Firstname
		driver.findElement(By.id("customer_lastname")).sendKeys("Gomez"); // Lastname
		driver.findElement(By.name("passwd")).sendKeys("1q2w3e4r5t"); // Password
		
		Select days = new Select(driver.findElement(By.cssSelector("#days")));
		days.selectByValue("18"); // Date of Birth - Day
		
		Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		month.selectByVisibleText("June "); // Date of Birth - Month
		
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByIndex(29); // Date of Birth - Year
		
		driver.findElement(By.name("newsletter")).click(); // Newsletter
		driver.findElement(By.cssSelector("#optin")).click(); // Offers
		
		// Segunda Sección: Direcciones
		driver.findElement(By.id("company")).sendKeys("MiEmpresa C.A."); // Company
		driver.findElement(By.cssSelector("#address1")).sendKeys("MiCalle 1357 4B"); // Address
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("entre calles A y B"); // Address 2
		driver.findElement(By.id("city")).sendKeys("Tucuman"); // City
		
		Select state = new Select(driver.findElement(By.name("id_state")));
		state.selectByVisibleText("Alaska"); // State
		
		driver.findElement(By.id("postcode")).sendKeys("90210"); // Zipcode
		driver.findElement(By.tagName("textarea")).sendKeys("Usuario creado por script"); // Additional Info
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1546574632"); // Home Phone
		driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("1567463822"); // Mobile Phone
		
		WebElement txtAlias = driver.findElement(By.id("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Mi Casa"); // Alias

		driver.findElement(By.xpath("//button[@id='submitAccount']")).click(); // Register
	}
}
