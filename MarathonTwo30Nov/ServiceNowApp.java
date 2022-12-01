package MarathonTwo30Nov;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNowApp {

	public static void main(String[] args) throws InterruptedException {
		   WebDriverManager.chromedriver().setup();
		   ChromeDriver driver = new ChromeDriver();
		   driver.get("https://dev138589.service-now.com/");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   
		   driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		   driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("mc/-vASs9V1E");
		   driver.findElement(By.xpath("//button[@type='submit']")).click();
		   
		   Shadow dom=new Shadow(driver);
		   dom.setImplicitWait(30);
		   Thread.sleep(2000);
		   dom.findElementByXPath("//div[@id='all']").click();
		   Thread.sleep(2000);
		   
		   WebElement servCatClk = dom.findElementByXPath("//span[text()='Service Catalog']");
		   driver.executeScript("arguments[0].click()", servCatClk);
		   Thread.sleep(3000);
		   
		  //switch to frame(shadow)-to click on Mobiles
		   WebElement frameMob = dom.findElementByXPath("//iframe[@id='gsft_main']");
		   driver.switchTo().frame(frameMob);
		   //click on Mobiles	   
		   WebElement mobClk = driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")); 
		   driver.executeScript("arguments[0].click()", mobClk);
		   
		   driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
		   
		   //select color from dropdown
		   WebElement color = driver.findElement(By.xpath("(//td[@class='iotd']/div/div/div/select)[2]"));
		   color.click();
		   Thread.sleep(1000);
		   Select ddcolor = new Select(color);
		   ddcolor.selectByValue("rose");
		   
		   //select storage from dropdown
		   WebElement storage = driver.findElement(By.xpath("(//td[@class='iotd']/div/div/div/select)[3]"));
		   storage.click();
		   Select ddStorage = new Select(storage);
		   Thread.sleep(1000);
		   ddStorage.selectByValue("onetwentyeight");
		   
		   driver.findElement(By.id("oi_order_now_button")).click();
		   
		   //verify order and take request number
		   WebElement verifyOrder = driver.findElement(By.xpath("//div[@class='notification notification-success']"));
		   System.out.println("Order confirmation: "+verifyOrder.getText());
		   WebElement requestNum = driver.findElement(By.xpath("//a[@id='requesturl']"));
		   System.out.println("Request Number: "+requestNum.getText());
		   
		   
		   
				   
		   
	}

}
