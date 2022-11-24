package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//span[text()='Submit']")).click();
		WebElement chkbox = driver.findElement(By.xpath("(//div[@class='ui-selectbooleancheckbox ui-chkbox ui-widget']/div[2])[3]"));
		boolean chkEnabled = chkbox.isEnabled();
		System.out.println(chkEnabled);
		

	}

}
