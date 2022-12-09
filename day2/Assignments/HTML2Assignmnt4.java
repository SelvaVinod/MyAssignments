package week4.day2.Assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML2Assignmnt4 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='render']/table//tr"));
		for (int i = 0; i < rows.size(); i++) {
			String rowVal = rows.get(i).getText();
					
		if(rowVal.contains("Absolute"))
			System.out.println(rowVal);
	}
}
}
