package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealMouseHover {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		   ChromeDriver driver = new ChromeDriver(options);
		   driver.get("https://www.snapdeal.com");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		   
		   WebElement menFash = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		   WebElement menShirt = driver.findElement(By.xpath("//span[text()='Shirts']"));
		   
		   Actions builder= new Actions(driver);
		   builder.moveToElement(menFash)
		   .click(menShirt)
		   .perform();
		   Thread.sleep(2000);
		    WebElement firstShirt = driver.findElement(By.xpath("//a[@class='dp-widget-link hashAdded']"));
		    builder.moveToElement(firstShirt).perform();
		    driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		    
		   
	}

}
