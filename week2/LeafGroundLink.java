package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLink {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Go to Dashboard")).click();
		driver.findElement(By.linkText("Find the URL without clicking me.")).click();
		driver.findElement(By.linkText("Find the URL without clicking me.")).click();
		driver.findElement(By.linkText("Broken?")).click();
		driver.findElement(By.linkText("Go to Dashboard")).click();
		driver.findElement(By.linkText("How many links in this page?")).click();
		driver.findElement(By.linkText("How many links in this layout?")).click();

	}

}
