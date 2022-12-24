package servicenow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class UpdateExistingIncident {

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
		dom.findElementByXPath("//input[@class='sn-global-typeahead-input -global']").sendKeys("INC0000004",Keys.ENTER);
		
		dom.findElementByXPath("//h3[@class='now-heading -title -primary has-no-margin']").click();
		Thread.sleep(2000);
		WebElement inciFrame = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(inciFrame);
		Thread.sleep(2000);
		WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']"));
	    Select ssstate = new Select(state);
	    ssstate.selectByValue("2");
	    String stateSelect = state.getText();
	    
	    //select urgency
	    WebElement urgdropdown = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
	    Select urgency = new Select(urgdropdown);
	    urgency.selectByValue("1");
	    String urgencySelect = urgdropdown.getText();
	    //update button click
	    driver.findElement(By.id("sysverb_update")).click();
	    //verify Urgency and State
	    if(stateSelect.contains("In Progress"))
	    		System.out.println("State is selected correctly");
	    else
	    	System.out.println("State is not selected correctly");
	    
	    if(urgencySelect.contains("High"))
	    	System.out.println("Urgency is selected correctly");
	    else
	    	System.out.println("Urgency is not selected correctly");
	    

	}

}
