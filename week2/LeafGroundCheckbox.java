package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		driver.findElement(By.xpath("(//div[@class='ui-chkbox ui-widget']/div[2])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='ui-chkbox ui-widget']/div[2])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='ui-chkbox ui-widget']/div[2])[3]")).click();
		driver.findElement(By.xpath("(//div[@class='ui-chkbox ui-widget']/div[2])[4]")).click();
		driver.findElement(By.xpath("(//div[@class='ui-chkbox ui-widget']/div[2])[5]")).click();
		driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-c ']/parent::div")).click();
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch ui-widget']/div[2]")).click();
		WebElement chkbox = driver.findElement(By.xpath("(//div[@class='ui-selectbooleancheckbox ui-chkbox ui-widget']/div[2])[3]"));
		boolean chkEnabled = chkbox.isEnabled();
		System.out.println(chkEnabled);
        driver.findElement(By.xpath("//div[@class='ui-selectcheckboxmenu-trigger ui-state-default ui-corner-right']")).click();
        Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//li[@class='ui-selectcheckboxmenu-item ui-selectcheckboxmenu-list-item ui-corner-all ui-selectcheckboxmenu-unchecked' ]/div/div[2])[3]")));
	}

}
