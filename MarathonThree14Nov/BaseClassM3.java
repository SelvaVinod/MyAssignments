package MarathonThree14Nov;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassM3 {

	public ChromeDriver driver;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url, String uName, String pwd) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);

	}
	
	@DataProvider(name="fetch")
	public String[][] setData() throws IOException{
		 //String[][] data= SalesReadExcel.readData();
		 //return data;
		return SalesReadExcel.readData();
	 }
	
	
	@DataProvider(name="fetch2")
	public String[][] getData() throws IOException{
		 //String[][] data= SalesReadExcel.readData();
		 //return data;
		return ReadExcelM2.readData();
	 }
//	@AfterMethod
//	public void postCondition() {
//		driver.close();
//		
//	}
}
