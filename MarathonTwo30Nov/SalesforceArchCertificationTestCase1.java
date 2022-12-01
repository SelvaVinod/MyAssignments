package MarathonTwo30Nov;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;


public class SalesforceArchCertificationTestCase1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//label[text()='Username']/following-sibling::div/input")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Testleaf$321");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//learn more in mobile publisher
		driver.findElement(By.xpath("//span[contains(text(),'Learn More')]")).click();
		
		Set<String> winHan= driver.getWindowHandles();
		List<String> window = new ArrayList<String>(winHan);
		driver.switchTo().window(window.get(1));
		//System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//shadow root dependency add for clicking learning tab
		Shadow dom = new Shadow(driver);
		//dom.setImplicitWait(30);
		Thread.sleep(3000);
		dom.findElementByXPath("//span[text()='Learning']").click();
		WebElement learnTrailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		WebElement salesForceCert = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		Actions act = new Actions(driver);
		act.moveToElement(learnTrailHead)
		.pause(Duration.ofSeconds(5))
		.click(salesForceCert).perform();
		
		//click on Sales Architect
		dom.findElementByXPath("//div[@class='roleMenu-item ']/a/div").click();
		//verify URl
		System.out.println("Current URL: "+driver.getCurrentUrl());
		
		String salesForceArchSummary = dom.findElementByXPath("//h1[text()='Salesforce Architect']/following-sibling::div").getText();
		System.out.println("Summary: "+salesForceArchSummary);
		
		List<WebElement> salesForceCertList = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		int certListSize= salesForceCertList.size();
		System.out.println(certListSize);
		for (int i = 0; i < certListSize; i++) {
			System.out.println("List of SalesForce Architect Certifications: " +salesForceCertList.get(i).getText());
			
		}
		
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		
		List<WebElement> applArchCertList = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		int applArchsize = applArchCertList.size();
		for (int i = 0; i < applArchsize; i++) {
			System.out.println("List of Application Architect Certification : "+applArchCertList.get(i).getText());
			
		}
			
}

		
		
}


