package MarathonOne16Nov;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3 {

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
        //click on Global Actions icon
        Thread.sleep(3000);
        driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='Global Actions']")));
        driver.findElement(By.xpath("//a[@title='New Task']")).click();
        driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");
        //status
        driver.findElement(By.xpath("(//div[@class='uiPopupTrigger']//a)[9]")).click();
        driver.findElement(By.xpath("//a[text()='Waiting on someone else']")).click();
        driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='Save']")));
        String taskCreateMsg = driver.findElement(By.xpath("//div[@class='slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage']")).getText();
        System.out.println(taskCreateMsg);
        
	}

}
