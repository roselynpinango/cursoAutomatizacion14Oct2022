package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos de la página y Variables Globales
	@FindBy(linkText="Sign in")
	WebElement lnkSignIn;
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	@FindBy(linkText="Contact us")
	WebElement lnkContactUs;
	
	WebDriver driver;
	
	// Constructor: inicializar la página
	public PaginaInicio(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Inicializar los elementos de ESTA página
	}
	
	// Métodos con las acciones que se pueden hacer sobre los elementos de la página
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerBusqueda() {
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	public void hacerClicEnContactUs() {
		lnkContactUs.click();
	}
}
