package week3Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

		public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags",Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='facet-linkfref ']//input[@value='Men']/following-sibling::label")).click();
		//driver.findElement(By.xpath("//a[text()='MEN']")).click();
		//driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//	driver.findElement(By.xpath("//a[text()='CATEGORIES']")).click();
				

	}

}
