package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaContactUs {
	@FindBy(tagName="select")
	WebElement selSubject;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(css="#id_order")
	WebElement txtOrderId;
	
	@FindBy(name="fileUpload")
	WebElement filAttached;
	
	@FindBy(tagName="textarea")
	WebElement txtMessage;
	
	@FindBy(id="submitMessage")
	WebElement btnSend;
	
	WebDriver driver;
	
	public PaginaContactUs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void seleccionarSubject(String subject) {
		Select lista = new Select(selSubject);
		lista.selectByVisibleText(subject);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirOrderId(String orderId) {
		txtOrderId.sendKeys(orderId);
	}
	
	public void adjuntarAdrchivo(String nombreArchivo) {
		filAttached.sendKeys(nombreArchivo);
	}
	
	public void escribirMessage(String message) {
		txtMessage.sendKeys(message);
	}
	
	public void hacerClicEnSend() {
		btnSend.click();
	}
}
