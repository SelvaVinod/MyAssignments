package week4.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundActions1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/drag.xhtml;jsessionid=node01qey7o6oowt9dc09s8l9hc4bu437441.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Drag around
		WebElement dragAround = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
		Point loc1 = dragAround.getLocation();
		System.out.println(loc1);
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(dragAround, 100, 100).perform();
		Point loc2 = dragAround.getLocation();
		System.out.println(loc2);
		
		if(loc1!=loc2)
			System.out.println("Drag succesful");
		else
			System.out.println("Drag not successful");	
		
		//Drag and Drop
		WebElement drag1 = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement drop1 = driver.findElement(By.xpath("//span[text()='Droppable Target']"));
		
		act.dragAndDrop(drag1, drop1).perform();
		
		WebElement droppedMsg = driver.findElement(By.xpath("//p[contains(text(),'Dropped')]"));
		String dropConfirm = droppedMsg.getText();
		
		if(dropConfirm.contains("Dropped"))
		System.out.println("Drag Drop successful");
		else
			System.out.println("Drag Drop not successful");
		
		//Draggable Columns - interchange category and quantity
		WebElement categr = driver.findElement(By.xpath("//span[text()='Category']"));
		//Point catLoc = categr.getLocation();
		WebElement quant = driver.findElement(By.xpath("//span[text()='Quantity']"));
		//Point quantLoc = quant.getLocation();
		act.dragAndDrop(quant, categr).perform();
		
		//Draggable Rows
		WebElement rowOne = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr[@data-ri='0']"));
		WebElement rowTwo = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr[@data-ri='2']"));
		act.dragAndDrop(rowTwo, rowOne).perform();

	}

}
