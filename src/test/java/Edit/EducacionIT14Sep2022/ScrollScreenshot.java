package Edit.EducacionIT14Sep2022;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

public class ScrollScreenshot {
	WebDriver driver;
	
	@Test
	public void scrollScreenshotTest() throws Exception {
		System.setProperty("webdriver.gecko.driver", "..\\EducacionIT14Sep2022\\Drivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.get("http://www.bbc.com");       
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File("..\\EducacionIT27Jul2022\\Evidencias\\fullPageScreenshot.png"));
		
		driver.close();
	}
	
}
