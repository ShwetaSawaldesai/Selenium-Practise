package introduction;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSortingJavaSeleniumStream {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		Thread.sleep(3000);
		List<WebElement> veggiesList = driver.findElements(By.xpath("//tr/td[1]"));
		// Original list
		List<String> originalList = veggiesList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// SortedList
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		System.out.println("Original List" + originalList);
		System.out.println("Original List" + sortedList);
		
		List<Object> price;
		
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			 price = rows.stream().filter(s->s.getText().contains("Rice"))
					.map(s->getPriceVeggies(s)).collect(Collectors.toList());
			System.out.println(price);
			if(price.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
				
			}
			
		}while(price.size()<1);
		
	}

	private static String getPriceVeggies(WebElement s) {
		// TODO Auto-generated method stub

		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
