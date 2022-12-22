package introduction;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VegetbleShopping {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] veggies = { "Beetroot", "Tomato", "Brocolli", "Carrot", "Beans" };
		addItems(driver, veggies);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//Explicit wait
		WebDriverWait  w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promocode")));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector(".promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		Thread.sleep(2000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] veggies) throws InterruptedException {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		List itemsNeeded = Arrays.asList(veggies);
		for (int i = 0; i < products.size(); i++) {
			String[] vegetables = products.get(i).getText().split("-");
			String vegetable = vegetables[0].trim();
			int j = 0;
			if (itemsNeeded.contains(vegetable)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				Thread.sleep(2000);
				System.out.println(vegetable);
				if (j == veggies.length) {
					break;
				}
			}

		}

	}
}
