package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumIntroduction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com/");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Select first checkbox and make sure it is checked
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption1")).isSelected();
		Thread.sleep(3000);
		//Unchecked the selected checkbox and make sure it is unchecked.
		driver.findElement(By.name("checkBoxOption1")).click();
		Thread.sleep(3000);
	    Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
	
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("checkbox-example")).getSize());
		
		driver.close();

	}

}
