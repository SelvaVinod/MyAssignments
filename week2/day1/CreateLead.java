package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	
	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Encora");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Selva");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Vinod");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Coaching");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("New Record Added Successfully");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("selvaganapathi.s@gmail.com");
		WebElement createTool = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(createTool);
		state.selectByValue("NY");
		WebElement eleTool = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select ss = new Select(eleTool);
		ss.selectByValue("LEAD_EMPLOYEE");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
		driver.findElement(By.name("submitButton")).click();
	    System.out.println("Page title is : " + driver.getTitle());
	    driver.close();
		
	}

}
