package MarathonOne16Nov;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://login.salesforce.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        WebElement sal = driver.findElement(By.xpath("//p[text()='Sales']"));
        driver.executeScript("arguments[0].click();", sal);
        WebElement acc = driver.findElement(By.xpath("//span[text()='Accounts']"));
        driver.executeScript("arguments[0].click();", acc);
        driver.findElement(By.xpath("//div[@title='New']")).click();
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Selva");
        //getAccount name
        String accName = driver.findElement(By.xpath("//input[@name='Name']")).getAttribute("value");
        System.out.println(accName);
        Thread.sleep(3000);
        //Ownership
        WebElement Ownship = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
        driver.executeScript("arguments[0].click();", Ownship);
        driver.findElement(By.xpath("//span[@title='Public']")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        
        String getAccName = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']/a")).getAttribute("title");
        System.out.println(getAccName);
      //validate Account name match
        if(accName.contains("Selva"))
      	  System.out.println(("Account Name matches correctly"));
        else
      	  System.out.println("Account Name does not match");
        
        
	}

}
