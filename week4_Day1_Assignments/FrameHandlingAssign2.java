package week4Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandlingAssign2 {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		   ChromeDriver driver = new ChromeDriver();
		   driver.get("https:chercher.tech/practice/frames-example-selenium-webdriver");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   driver.switchTo().frame("frame1");
		   driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Frame Handling");
		   
		   driver.switchTo().frame("frame3");
		   WebElement chkbox = driver.findElement(By.xpath("//b[contains(text(),'Inner Frame Check box')]/following-sibling::input"));
		   chkbox.click();
		   if(chkbox.isSelected())
			   System.out.println("Check box is selected");
		   else
			   System.out.println("Check box is not selected");
		   driver.switchTo().defaultContent();
		   driver.switchTo().frame("frame2");
		   WebElement dropAnim = driver.findElement(By.xpath("//select[@id='animals']"));
		   Select dd = new Select(dropAnim);
		   dd.selectByIndex(3);
		   
		   
		   

	}

}
