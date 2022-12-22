package introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		SoftAssert sa = new SoftAssert();
		List<WebElement> footerLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for (WebElement footerLink : footerLinks) {
			String url = footerLink.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			int responseCode = conn.getResponseCode();
			sa.assertTrue(responseCode<400, "The broken link " + url + " with status" + responseCode);
			 sa.assertAll();
			//Hard assertion using Assert.assetTrue
//			if (responseCode > 400) {
//				System.out.println(responseCode);
//				System.out.println("The broken link " + url + " with status" + responseCode);
//				Assert.assertTrue(false);
//
//			}

		}

	}

}
