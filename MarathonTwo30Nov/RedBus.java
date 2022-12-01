package MarathonTwo30Nov;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws IOException, InterruptedException {
		 WebDriverManager.chromedriver().setup();
		   ChromeDriver driver = new ChromeDriver();
		   driver.get("https://www.redbus.in");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   
		   driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		   driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/li[2]")).click();
		   driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		   driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/li[2]")).click();
		   driver.findElement(By.xpath("//label[text()='Date']")).click();
		   driver.findElement(By.xpath("//button[text()='>']")).click();
		   driver.findElement(By.xpath("//td[@class='wd day']")).click();
		   driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		   
		   String busFound = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		   System.out.println(busFound);
		   
		   driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		   String secondBusName = driver.findElement(By.xpath("(//div[@class='column-two p-right-10 w-30 fl'])[2]")).getText();
		   System.out.println(secondBusName);
		   //click View seats of second bus
		   driver.findElement(By.xpath("(//div[@class='clearfix m-top-16']/div[text()='View Seats'])[2]")).click();
		   
		   Thread.sleep(3000);
		   //take screenshot
		   File src=driver.getScreenshotAs(OutputType.FILE);
		   File dest=new File("./snaps/redbus.png");
		   FileUtils.copyFile(src, dest);	   
		   
	}

}
