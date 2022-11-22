package MarathonOne16Nov;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://login.salesforce.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        WebElement sal = driver.findElement(By.xpath("//p[text()='Sales']"));
        driver.executeScript("arguments[0].click();", sal);
        WebElement opp = driver.findElement(By.xpath("//span[text()='Opportunities']"));
        driver.executeScript("arguments[0].click();", opp);
        driver.findElement(By.xpath("//div[text()='New']")).click();
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Selva");
       //to get text of Opportunity name
        String oppName = driver.findElement(By.xpath("//input[@name='Name']")).getAttribute("value");
        System.out.println(oppName);
        driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("11/16/2022");
        driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
        driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        String getoppName = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']/a")).getAttribute("title");
        System.out.println(getoppName);
      
      //validate Opportunity name match
      if(oppName.contains("Selva"))
    	  System.out.println(("Opportunity Name matches correctly"));
      else
    	  System.out.println("Opportunity Name does not match");
            
	}

}

