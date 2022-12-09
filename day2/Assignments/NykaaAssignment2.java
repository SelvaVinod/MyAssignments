package week4.day2.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		//WebElement loreal = driver.findElement(By.xpath("//a[contains(text(),'real Paris')]"));
		Actions act =new Actions(driver);
		act.moveToElement(brand).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris",Keys.ENTER);
		driver.findElement(By.xpath("//div[@id='scroller-container']/div[2]/a[text()=\"L'Oreal Paris\"]")).click();
		
		System.out.println("Title: "+driver.getTitle());
		
		driver.findElement(By.xpath("//span[contains(text(),'popularity')]")).click();
		driver.findElement(By.xpath("//input[@id='radio_customer top rated_undefined']/following-sibling::label/div[2]")).click();
		//category-hair care
		driver.findElement(By.id("category")).click();
		WebElement hairHover = driver.findElement(By.xpath("//a[text()='hair']"));
		WebElement shampoo = driver.findElement(By.xpath("//a[text()='Shampoo']"));
		act.moveToElement(hairHover).click(shampoo).perform();
		
		Thread.sleep(2000);
		//concern-color protection
		//WebElement concern = driver.findElement(By.xpath("//span[contains(text(),'Concern')]/following-sibling::div"));
		
		Set<String> windows=driver.getWindowHandles();
		List<String> win = new ArrayList<String>(windows);
		
		driver.switchTo().window(win.get(1));
		//act.scrollToElement(concern).pause(Duration.ofSeconds(20)).perform();
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='Concern']")));
		driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']/div[2]")).click();
		String verifyShampoo = driver.findElement(By.xpath("//h1[text()='Hair Shampoo']")).getText();
		System.out.println(verifyShampoo);
		if(verifyShampoo.contains("Shampoo"))
			System.out.println("Color protection filter applied with Shampoo");
		else
			System.out.println("Color protection filter not applied with Shampoo");
		Thread.sleep(1000);
		//choose brand and select loreal paris colour protect shampoo
		driver.findElement(By.xpath("//span[text()='Brand']")).click();
		driver.findElement(By.xpath("//div[@class=\'sidebar__inner\']/div/div/input")).sendKeys("Paris",Keys.ENTER);
		driver.findElement(By.xpath("//label[@class=\"control control-checkbox\"]/div/span")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
		
		windows=driver.getWindowHandles();
		win=new ArrayList<String>(windows);
		driver.switchTo().window(win.get(2));
		
		//size as 175ml
		WebElement sizeSelect= driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dd = new Select(sizeSelect);
		dd.selectByValue("0");
		//print MRP of product
		String mrpValue = driver.findElement(By.xpath("//span[contains(text(),'MRP')]/following-sibling::span")).getText();
		System.out.println("L'oreal paris shampoo Price: "+mrpValue.replace("₹", "₹"));
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		String grandTot = driver.findElement(By.xpath("//div[@data-test-id='footer']/div/div/div/div/div/div/span")).getText();
		System.out.println("Grand total: "+grandTot);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		windows=driver.getWindowHandles();
		win=new ArrayList<String>(windows);
		driver.switchTo().window(win.get(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		driver.navigate().back();
		String finalTot = driver.findElement(By.xpath("//div[@id='app']/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/p")).getText();
		System.out.println("Final Total : "+finalTot);
		if(grandTot==finalTot)
			System.out.println("Both Totals are same");
		else
			System.out.println("Both Totals are not same");
		driver.quit();

	}

}
