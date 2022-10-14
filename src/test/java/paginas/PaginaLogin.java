package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	// Elementos de la pagina y Variables Globales
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtPassword;
	
	@FindBy(name="SubmitLogin")
	WebElement btnLogin;
	
	WebDriver driver;
	
	// Constructor
	public PaginaLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Acciones sobre los elementos de la pagina
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void hacerClicEnLogin() {
		btnLogin.click();
	}
	
	public void ingresarCredenciales(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
