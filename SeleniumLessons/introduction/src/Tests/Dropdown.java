package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Navigate to url and fill the form details
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Shweta");
		driver.findElement(By.name("email")).sendKeys("123@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("12*wstu");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		WebElement dropdown = driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
		Select dropdownValues = new Select(dropdown);
		dropdownValues.selectByIndex(1);
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("12-10-2022");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector(".alert")).getText());
		
		
		

	}

}
