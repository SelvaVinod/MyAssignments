package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundInput {

	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/input.xhtml;jsessionid=node01j540a7o52can13p945ps0fry4418339.node0");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='j_idt88:name']")).sendKeys("Selvaganapathi");
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt91']")).clear();
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt91']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt95']")).clear();
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt95']")).sendKeys("Clear the text");
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt97']")).clear();
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt97']")).sendKeys("My learning is super on weekly basis");
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']")).sendKeys("selvaganapathi.s@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='j_idt88:j_idt101']")).sendKeys("This is my first testing");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='col-12 mb-2 lg:col-8']/input[@name='j_idt106:thisform:age']")).sendKeys(Keys.ENTER);
		String errMsg = driver.findElement(By.xpath("//span[text()='Age is mandatory']")).getText();
		System.out.println(errMsg);
		
		Point loc = driver.findElement(By.xpath("//span[@class='ui-float-label']/input")).getLocation();
		System.out.println(loc);
		driver.findElement(By.xpath("//span[@class='ui-float-label']/input")).click();
		Point loc11 = driver.findElement(By.xpath("//span[@class='ui-float-label']/input")).getLocation();
		System.out.println(loc11);
		if(loc == loc11) {
			System.out.println("Label position is same");
		}
		else {
			System.out.println("Label position is not same");
		}
		driver.findElement(By.xpath("//button[@aria-label='Show Options' and @role='button']/preceding-sibling::ul/li/input")).sendKeys("Selva");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='j_idt106:auto-complete_panel']/ul/li[3]")).click();
		driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-icon ui-icon-calendar']")).click();
		driver.findElement(By.xpath("//td[@class=' ui-datepicker-today']/a")).click();
		String num ="3";
		driver.findElement(By.xpath("//span[@class='ui-spinner ui-widget ui-corner-all ui-spinner-stacked']/input")).sendKeys(num);
		WebElement spinUp = driver.findElement(By.xpath("(//span[contains(@class,'ui-spinner ui-widget ui-corn')]/input/following-sibling::a)[1]"));
		spinUp.click();
		String finNum = driver.findElement(By.xpath("//span[contains(@class,'ui-spinner ui-widget ui-corn')]/input")).getAttribute("value");
		System.out.println(finNum);
//		WebElement spinDown = driver.findElement(By.xpath("(//span[contains(@class,'ui-spinner ui-widget ui-corn')]/input/following-sibling::a)[2]"));
//		spinDown.click();
		if(num.equals(finNum)) 
			System.out.println("Value changed after spin");
			else
				System.out.println("Value not changed after spin");
		driver.findElement(By.xpath("(//h5[contains(text(),'Type random number')]/following-sibling::input)[1]")).sendKeys("50");
		Thread.sleep(2000);
		String slideCheck = driver.findElement(By.xpath("//div[contains(@class,'ui-slider ui-corner-all')]/span")).getAttribute("style");
		System.out.println(slideCheck);
		
		
	driver.findElement(By.xpath("(//h5[contains(text(),'Click and Confirm Keyboard appears')]/following-sibling::input)[1]")).sendKeys("30");
	
		if(driver.findElement(By.xpath("//div[@class='keypad-row']")).isDisplayed()) {
			System.out.println("Keyboard is displayed");
		}
		else
			System.out.println("Keyboard is not displayed");
		}	
		
		
		
		
	}

