package MarathonThree14Nov;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test(dataProvider="fetch")
public class TestngSalesforceTestCase1 extends BaseClassM3{
	
	public void marathon3Test01(String question, String details) throws InterruptedException, IOException {

		   driver.findElement(By.xpath("//input[@id='Login']")).click();
		   driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		   driver.findElement(By.xpath("//button[text()='View All']")).click();
		   driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("content");
		   driver.findElement(By.xpath("//mark[text()='Content']")).click();
		   WebElement chatterClick = driver.findElement(By.xpath("//span[text()='Chatter']"));
		   driver.executeScript("arguments[0].click()", chatterClick);
		   Thread.sleep(2000);
		   System.out.println("Chatter Page Title : "+driver.getTitle());
		   
		   driver.findElement(By.xpath("//span[text()='Question']")).click();
		   //question from excel
		   WebElement ques = driver.findElement(By.xpath("//textarea[contains(@placeholder,'know')]"));
		   ques.sendKeys(question);
		   
		   
		   //details from excel	   
		   driver.findElement(By.xpath("//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']")).sendKeys(details);
		   
		   driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton qe-questionPostDesktop MEDIUM']")).click();
		   
		   String quesCheck= driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		   System.out.println("Question check: "+quesCheck);
		   System.out.println("Question : "+question);
		   
		   if(quesCheck.contains(question)) {
			   System.out.println("Question matched");
		   }
		   else {
			   System.out.println("Question not matched");
	}
}		   

  
}


