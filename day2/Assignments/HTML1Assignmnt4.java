package week4.day2.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML1Assignmnt4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr/td/a"));
		List<WebElement> col =driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr[2]/td"));
		int rowSize = row.size();
		int colSize = col.size();
		System.out.println(rowSize);
		System.out.println(colSize);
		

	}

}
