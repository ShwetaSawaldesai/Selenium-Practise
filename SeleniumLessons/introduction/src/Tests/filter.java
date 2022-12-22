package introduction;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Brinjal");
		List<WebElement> filteredList = driver.findElements(By.xpath("//tr/td[1]"));
		List <WebElement> serachedValues = filteredList.stream().filter(s -> s.getText().contains("Brinjal"))
				.collect(Collectors.toList());
		Assert.assertEquals(filteredList.size(), serachedValues.size());
		System.out.println(filteredList.size());

	}

}
