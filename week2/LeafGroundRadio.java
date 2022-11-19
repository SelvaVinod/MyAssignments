package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundRadio {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/radio.xhtml");
		driver.manage().window().maximize();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[12]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[13]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[14]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[15]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[16]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[17]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[18]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[19]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[20]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[21]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[22]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[23]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[24]")).click();
        driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']/div[2])[25]")).click();
        

	}

}
