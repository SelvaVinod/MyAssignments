package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		System.out.println("Page title is : " + driver.getTitle());
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Encora");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Selva");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Vinod");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Coaching");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("New Record Added Successfully");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("selvaganapathi.s@gmail.com");
		WebElement createTool = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(createTool);
		state.selectByValue("NY");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
		driver.findElement(By.name("submitButton")).click();
		
		//DuplicateLead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Test");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Page title is : " + driver.getTitle());
		
		
		
		

	}

}
