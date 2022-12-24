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

public class AssignIncident {

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
		
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(20);
		dom.findElementByXPath("//input[@class='sn-global-typeahead-input -global']").sendKeys("INC0000005",Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement inciFrame = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(inciFrame);
		Thread.sleep(2000);
			
		//Assign the incident
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[5]")).click();
		Thread.sleep(1000);	
				
		WebElement assignGroup = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']"));
		assignGroup.clear();
		assignGroup.sendKeys("Software",Keys.ENTER);
		Thread.sleep(2000);
		WebElement assignTo = driver.findElement(By.xpath("//input[@id='sys_display.incident.assigned_to']"));
		assignTo.clear();
		assignTo.sendKeys("David",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='activity-stream-work_notes-textarea']")).sendKeys("Incident assigned to David");
		
		//Verify Assigned Group and Assigned Info
		String verifyassgnGrp = assignGroup.getText();
		String verifyassgnTo = assignTo.getText();
		System.out.println(verifyassgnGrp);
		System.out.println(verifyassgnTo);
		if(verifyassgnGrp.contains("Software") && verifyassgnTo.contains("David"))
			System.out.println("Group and Person assigned correctly");
		else
			System.out.println("Group and Person not assigned correctly");
		
		
	}

}
