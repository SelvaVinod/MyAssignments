package week4Assignments;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
	   WebDriverManager.chromedriver().setup();
	   ChromeDriver driver = new ChromeDriver();
	   driver.get("https://www.amazon.in/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
	   driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	   //Print the first product price
	   WebElement whole = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
	   String fprice = whole.getText();
	   System.out.println("First product price: "+fprice);
	   
	   //Customer rating of the first product
	   WebElement ratings = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-micro']/div/span[2]/a"));
	   String rating = ratings.getText();
	   System.out.println("Ratings of the product: "+rating);
	   //First text link click
	   driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])")).click();
	   //Take a screenshot
	   Set<String> text = driver.getWindowHandles();
	   List<String> text1 = new ArrayList<String> (text);
	   driver.switchTo().window(text1.get(1));
	   File source = driver.getScreenshotAs(OutputType.FILE);
	   File dest = new File ("./snaps/Amazon.png");
	   FileUtils.copyFile(source, dest);
	   //Add to cart
	   driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	   Thread.sleep(3000);
	   //Verify the cart sub total
	   WebElement cart = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
	   String sub = cart.getText();
	   System.out.println(sub);
	   //int sub2 = Integer.parseInt(sub);
	   //System.out.println("Fist sub total: "+sub2);
	   if(sub.contains(fprice)){
		   System.out.println("Fist list card total is matched");
	   }
		   else {
		   
		    System.out.println("First list card total is not matched");
		   }
	   //close the browser
	   driver.close();
	   }
	   

	}


