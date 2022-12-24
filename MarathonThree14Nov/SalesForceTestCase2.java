package MarathonThree14Nov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SalesForceTestCase2 extends BaseClassM3{
	@Test(dataProvider = "fetch2")
	public void Opportunities(String oppName, String amount) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		   driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		   driver.findElement(By.xpath("//button[text()='View All']")).click();
		   driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("sales");
		   WebElement sales = driver.findElement(By.xpath("(//p[@class='slds-truncate']/mark)[3]"));
		   driver.executeScript("arguments[0].click()", sales);
		   
//		   driver.findElement(By.xpath("//span[text()='Key Deals Trigger']")).click();
//		   driver.findElement(By.xpath("//a[@title='New Last Week']")).click();
		   WebElement allDeals = driver.findElement(By.xpath("(//a[@class='viewAllLink']/span)[4]"));
		   driver.executeScript("arguments[0].click()", allDeals);
//		   WebElement oppClick = driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container']/lightning-primitive-icon"));
//		   driver.executeScript("arguments[0].click()", oppClick);
		   Thread.sleep(1000);
//		   WebElement allOppClk = driver.findElement(By.xpath("//span[text()='All Opportunities']"));
//		   driver.executeScript("arguments[0].click()", allOppClk);
		   driver.findElement(By.xpath("//div[text()='New']")).click();
		   
		   //read from excel
		   driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(oppName);
		   driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
		   
		   driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		   driver.findElement(By.xpath("//button[@title='Next Month']")).click();
		   driver.findElement(By.xpath("//span[text()='20']")).click();
		   driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		   
		   Thread.sleep(2000);
		  
		   WebElement primary = driver.findElement(By.xpath("(//div/input[@class='slds-combobox__input slds-input'])[2]"));
			driver.executeScript("arguments[0].click();",primary);
			driver.findElement(By.xpath("//span[text()='Bootcamp']")).click();
			Thread.sleep(3000);
		  
			WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
			driver.executeScript("arguments[0].click();",save);
			Thread.sleep(3000);
			
			String confirmName = driver.findElement(By.xpath("//span[text()='Opportunity']/a")).getAttribute("title");
			if(oppName.contains(confirmName))
				System.out.println("Opportunity name matches correctly");
			else
				System.out.println("Opportunity name mismatch");
		  
		   
		   
	}

}
