package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		driver.findElement(By.linkText("Create New Account")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("SelvaKivi");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Vinod");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("7904962645");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Kivi123");
        WebElement daySelection = driver.findElement(By.id("day"));
        Select day = new Select(daySelection);
        day.selectByValue("24");
        WebElement monthSelection = driver.findElement(By.name("birthday_month"));
        Select month = new Select(monthSelection);
        month.selectByVisibleText("Jun");
        WebElement yearSelection = driver.findElement(By.name("birthday_year"));
        Select year = new Select(yearSelection);
        year.selectByVisibleText("1983");
        driver.findElement(By.name("sex")).click();
	}

}
