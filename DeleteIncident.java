package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class DeleteIncident {

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
		dom.findElementByXPath("//h3[@class='now-heading -title -primary has-no-margin']").click();
		Thread.sleep(2000);
		
		WebElement inciFrame = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(inciFrame);
		Thread.sleep(2000);
		
		WebElement deleteButton = driver.findElement(By.xpath("//button[@id='sysverb_delete_bottom']"));
		driver.executeScript("arguments[0].click()", deleteButton);
		
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='input-group-addon input-group-select']/following-sibling::input")).sendKeys("INC0000005",Keys.ENTER);
		   
		boolean inciNum = driver.findElement(By.xpath("//tr[@data-list_id='incident']/td[3]")).isDisplayed();
		if(inciNum) 
			System.out.println("Incident not deleted");
			else
				System.out.println("Incident deleted successfully");
		}
		
	}


