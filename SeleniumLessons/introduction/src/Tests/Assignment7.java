package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Print total number of rows in 
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
		int rowsOfTable = rows.size();
		System.out.println(rowsOfTable);
		
		//Print total number of columns in the table.
		List<WebElement> columns = driver.findElements(By.cssSelector(".table-display th"));
		int columnsInTable = columns.size();
		System.out.println(columnsInTable);
		
		//Print data in the second row of the table
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
		
		
	}

}



//public class Assignment7 {
//
//	public static void main(String[] args) {
//
//// TODO Auto-generated method stub
//
//		System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
//
//		WebDriver driver = new ChromeDriver();
//
//		driver.get("http://qaclickacademy.com/practice.php");
//
//		WebElement table = driver.findElement(By.id("product"));
//
//		System.out.println(table.findElements(By.tagName("tr")).size());
//
//		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
//
//		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
//
//		System.out.println(secondrow.get(0).getText());
//
//		System.out.println(secondrow.get(1).getText());
//
//		System.out.println(secondrow.get(2).getText());
//
//	}
//
//}
