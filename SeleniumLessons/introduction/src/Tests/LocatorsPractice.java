package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		// Sign in
		driver.findElement(By.id("inputUsername")).sendKeys("Shweta");
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("1234");
		driver.findElement(By.className("submit")).click();

		// Click on forgot password link
		Thread.sleep(2000);
		driver.findElement(By.linkText("Forgot your password?")).click();

		// Forgot password
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("User1");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("user@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("1234");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		// Extract password from the text
		String text = driver.findElement(By.cssSelector(".infoMsg")).getText();
		System.out.println(text);
		String[] text2 = text.split("'");
		System.out.println(text2[0]);
		System.out.println(text2[1]);
		System.out.println(text2[2]);

		// Enter correct password in extracted from the text and login.
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		String name = "Shwetaa";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(text2[1]);
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.className("submit")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),
				"Hello " + name + ",");
		String successfullyLogin = "You are successfully logged in.";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(),
				successfullyLogin);
		driver.close();

	}

}
