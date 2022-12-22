package introduction;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentOnMobileShopping {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@id='usertype']")).click();
		Thread.sleep(2000);
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
//		driver.findElement(By.id("okayBtn")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@data-style=\"btn-info\"]"));
		Select dropdownValues = new Select(dropdown);
		dropdownValues.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		for(int i = 0; i<products.size(); i++) {
			products.get(i).click();
	}
		
		driver.findElement(By.partialLinkText("Checkout")).click();
		
	}

}
