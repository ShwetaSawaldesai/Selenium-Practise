package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//Scroll the table on the page
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		//get the values in column Amount in table.
		
		List<WebElement> columnAmount = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum =0;
		for(int i=0; i<columnAmount.size(); i++) {
			sum = sum + Integer.parseInt(driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")).get(i).getText());	
		}
		
		System.out.println(sum);
		
		//Assert the sum with total amount
		String text = driver.findElement(By.cssSelector(".totalAmount")).getText();
		String[] total = text.split(":");
		Assert.assertEquals(sum, Integer.parseInt(total[1].trim()));
		
	}

}
