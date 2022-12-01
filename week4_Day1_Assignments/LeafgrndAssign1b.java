package week4Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgrndAssign1b {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		   ChromeDriver driver = new ChromeDriver();
		   driver.get("https://leafground.com/window.xhtml;jsessionid=node0ssnceyfd5mtq1u38yu3inp0zh436503.node0");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		   
		   //Click and Confirm new Window Opens
		   driver.findElement(By.xpath("//span[text()='Open']")).click();
		   Set<String> winHan= driver.getWindowHandles();
		   List<String> window = new ArrayList<String>(winHan);
		   
		   //go to dashboard window
		   driver.switchTo().window(window.get(1));
		   System.out.println(driver.getTitle());
		   System.out.println(window.size());
		   for(int i=1;i<window.size();i++)
			   driver.switchTo().window(window.get(i)).close();
		   //go back to home window
		   driver.switchTo().window(window.get(0));
		   
		   //Find the number of opened tabs
		   driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		   winHan=driver.getWindowHandles();
		   window= new ArrayList<String>(winHan);
		 System.out.println(window.size());
		   for(int i=1;i<window.size();i++)
			   driver.switchTo().window(window.get(i)).close();
//		   driver.switchTo().window(window.get(2)).close();
//		   driver.switchTo().window(window.get(1)).close();
		   
		   
		 //go back to home window
		   driver.switchTo().window(window.get(0));
		   
		   //Close all windows except Primary
		   driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		   winHan=driver.getWindowHandles();
		   window= new ArrayList<String>(winHan);
		   for(int i=1;i<window.size();i++)
			   driver.switchTo().window(window.get(i)).close();
		   
		 //go back to home window
		   driver.switchTo().window(window.get(0));
		   
		   //Wait for 2 new tabs to open
		   driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		   winHan=driver.getWindowHandles();
		   window= new ArrayList<String>(winHan);
		   WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		   wait.until(ExpectedConditions.numberOfWindowsToBe(3));  
		   for(int i=1;i<window.size();i++)
			   driver.switchTo().window(window.get(i)).close();
		   driver.switchTo().window(window.get(0));
		   //driver.quit();
		   
		   
		   
		   

	}

}
