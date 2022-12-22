package introduction;

import java.time.Duration;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid...]
		java.util.Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String Text = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String[] splittedText = Text.split("at");
		System.out.println(splittedText[1]);
		
		String[] emailText = splittedText[1].split("with");
		String email = emailText[0].trim();
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
		
		
		
		
		
		
		
	}

}
