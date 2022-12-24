package servicenow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;


public class CreateInstance {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev100362.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Sanju@123");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(2000);
		
		 Shadow dom=new Shadow(driver);
		   dom.setImplicitWait(30);
		  
		   dom.findElementByXPath("//div[@class='sn-polaris-tab can-animate polaris-enabled']").click();
		   Thread.sleep(1000);
		 
		   dom.findElementByXPath("//span[text()='Incidents']").click();
		   Thread.sleep(2000);
		   WebElement frameMob = dom.findElementByXPath("//iframe[@id='gsft_main']");
		   driver.switchTo().frame(frameMob);
		   //driver.switchTo().frame(1);
		   WebElement newButton = driver.findElement(By.xpath("//button[@class='selected_action action_context btn btn-primary']"));	
		   driver.executeScript("arguments[0].click()", newButton);
		   driver.findElement(By.id("incident.number")).clear();
		   driver.findElement(By.id("incident.number")).sendKeys("INC0000005");
		   driver.findElement(By.id("incident.short_description")).sendKeys("My First Incident");
		   WebElement submit = driver.findElement(By.xpath("//button[@class='form_action_button header  action_context btn btn-default']"));
		   driver.executeScript("arguments[0].click()", submit);
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//span[@class='input-group-addon input-group-select']/following-sibling::input")).sendKeys("INC0000005",Keys.ENTER);
		   String inciNum = driver.findElement(By.xpath("(//tr[@data-list_id='incident']/td[3])[1]")).getText();
		   System.out.println(inciNum);
			if(inciNum.contains("INC0000005"))
				System.out.println("Incident created successfully");
			else
				System.out.println("Incident not created");

		  		   
		   
	
	}

}
