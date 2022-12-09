package week4.day2.Assignments;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittorgarhAssignmnt4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		List<WebElement> secLink = driver.findElements(By.xpath("//div[@class=\'table-responsive\']/table/tbody/tr/td[3]"));
		int secLinkSize = secLink.size();
		System.out.println("Total Security names Links: "+secLinkSize);
		
		for (int i = 1; i <= secLinkSize; i++) {
		String text = driver.findElement(By.xpath("//div[@class=\'table-responsive\']/table/tbody/tr["+i+"]/td[3]")).getText();
		System.out.println(text);
		}
	}

}
