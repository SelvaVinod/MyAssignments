package week4.day2.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class SnapDealAssignmnt4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		   ChromeDriver driver = new ChromeDriver(options);
		   driver.get("https://www.snapdeal.com");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		   
		   WebElement menFash = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		   menFash.click();
		   WebElement sportShoe = driver.findElement(By.xpath("//span[text()=\"Sports Shoes\"]"));
		   sportShoe.click();
		   
		   List<WebElement> shoeTot = driver.findElements(By.xpath("//div[@class='product-tuple-description ']/div/a/p"));
		   System.out.println("Total Count of shoes in 1 page: "+shoeTot.size());
		   
		   WebElement trainShow = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		   trainShow.click();
		   
		  
		   
		   WebElement popDropdown = driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']"));
		   popDropdown.click();
		   //WebElement popularityType = driver.findElement(By.xpath("//li[@data-sorttype='plth']"));
		   WebElement popularityType = driver.findElement(By.xpath("//div[@id=\"content_wrapper\"]/div[9]/div[2]/div[2]/div[3]/div[2]/ul/li[2]"));
		   popularityType.click(); 
		   String popType = popularityType.getText();
		   
		   if(popType.contentEquals("Low To High"))
			   System.out.println("Items sorted successfully");
		   else
			   System.out.println("Items not sorted");
		 //price range
		   WebElement fromvalue = driver.findElement(By.xpath("//input[@name='fromVal']"));
			fromvalue.clear();
			fromvalue.sendKeys("900");
			WebElement tovalue = driver.findElement(By.xpath("//input[@name='toVal']"));
			tovalue.clear();
			tovalue.sendKeys("1200");
			
			driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
			//in 900-1200 price , only yellow color is available
			WebElement color = driver.findElement(By.xpath("(//a[@class='filter-name'])[5]"));
			driver.executeScript("arguments[0].click()", color);
			
			
			//verify all filters
			String priceSelected = driver.findElement(By.xpath("//a[@data-key='Price|Price']")).getText();
			System.out.println(priceSelected);
			String colorSelected = driver.findElement(By.xpath("//a[@data-key='Color_s|Color']")).getText();
			System.out.println(colorSelected);
			
			WebElement firstElement = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
			

			Actions act = new Actions(driver);
			act.moveToElement(firstElement).perform();
			WebElement quickView = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
			driver.executeScript("arguments[0].click()", quickView);
			
			driver.findElement(By.xpath("//a[contains(text(),'view details')]")).click();
			Thread.sleep(2000);
			String finalPrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
			System.out.println("Final Price: "+finalPrice);
			String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
			System.out.println("Discount: "+discount);
			
			//take screenshot
			File source = driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshot/snapdeal.png");
			FileUtils.copyFile(source, dest);
			driver.close();
			driver.quit();
	}

}
