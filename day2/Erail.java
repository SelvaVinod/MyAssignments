package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement fromStat = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		fromStat.clear();
		fromStat.sendKeys("MAS");
		WebElement toStat = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		toStat.sendKeys("CBE",Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
		List<WebElement> trainList= driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//td[2]/a"));
		List<String> trainNames = new ArrayList<String>();
		for (WebElement ele : trainList) {
			trainNames.add(ele.getText());
					}
		Set<String> trains = new HashSet<String>(trainNames);
		
		System.out.println("Train list size: "+trainNames.size());
		System.out.println("Train set size: "+trains.size());
		if(trainNames.size() == trains.size())
			System.out.println("No duplicate train names present");
		else
			System.out.println("Duplicates present");

	}

}
