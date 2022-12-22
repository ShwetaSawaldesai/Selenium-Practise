package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeSelectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//1.Above()
		WebElement nameTextBox = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameTextBox)).getText());
		
		//2.below()
		WebElement dateOfBirth = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
//		System.out.println(driver.findElement(with(By.tagName("input")).below(dateOfBirth)));
		
		//3.toLeftOf()
		WebElement checkboxtext = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxtext)).click();
		
		//4.toRightOf()
		WebElement radioBtn = driver.findElement(By.id("inlineRadio1"));
		String text = driver.findElement(with(By.tagName("label")).toRightOf(radioBtn)).getText();
		
		System.out.println(text);

	}

}
