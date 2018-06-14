package patch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class kenzenpatch {

	
	static WebDriver kenzen;
	
	public kenzenpatch()
	
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Learning\\chromedriver.exe");
		
		kenzen = new ChromeDriver();
		
	};
	
	@Test

	public void login()
	{
		kenzen.manage().window().maximize();
		kenzen.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		kenzen.get("http://qa.kenzen.com/");
		kenzen.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/div[1]/input")).sendKeys("qa1@kenzen.com");
		kenzen.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys("Kenzen@123");
		kenzen.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/button")).click();
	
	}
	
}
