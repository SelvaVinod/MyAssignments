package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonListOfPrizes {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phones",Keys.ENTER);
		List<WebElement> allMob = driver.findElements(By.className("a-price-whole"));
		List<Integer> priceList1 = new ArrayList<Integer>();
		for (WebElement eachMobile : allMob) {
			System.out.println(eachMobile.getText());
			
			String text = eachMobile.getText().replace(",", "");
			String replace=text.replace(",", "");
			
			int price = Integer.parseInt(replace);
			priceList1.add(price);
		}
			Collections.sort(priceList1);
			System.out.println("Least Price: "+priceList1.get(0));
		
		
	}

}
