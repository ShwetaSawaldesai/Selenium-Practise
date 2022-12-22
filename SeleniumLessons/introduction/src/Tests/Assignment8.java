package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	private static final boolean WebElement = false;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Auto-suggestive dropdowns.
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input")).sendKeys("Ind");
		Thread.sleep(3000);
		List <WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
	
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
			
			
		}

	}

}
