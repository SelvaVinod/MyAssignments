package week4Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapAssgnmt1a {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		   ChromeDriver driver = new ChromeDriver();
		   driver.get("http://leaftaps.com/opentaps/control/login");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   
		   	driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
			
			//Merge contact widget click-From contact
			driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
			Set<String> winHan	= driver.getWindowHandles();
			List<String> window = new ArrayList<String>(winHan);
		   
			driver.switchTo().window(window.get(1));
			System.out.println(driver.getTitle());
			System.out.println(window.size());
			
			//click on Widget 1st link- From Contact
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			//go back to previous window
			driver.switchTo().window(window.get(0));
			
			//Merge contact widget click-From contact
			
			driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
			winHan	= driver.getWindowHandles();
			window = new ArrayList<String>(winHan);
		   
			driver.switchTo().window(window.get(1));
			System.out.println(driver.getTitle());
			System.out.println(window.size());
			
			//click on Widget 2nd link- To Contact
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
			//go back to previous window
			driver.switchTo().window(window.get(0));
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
			driver.switchTo().alert().accept();
			System.out.println(driver.getTitle());
			
			
			

	}

}
