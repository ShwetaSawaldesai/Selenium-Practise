package introduction;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Switch between two tabs or windows
		driver.switchTo().newWindow(WindowType.TAB );
		Set<String> handles = driver.getWindowHandles();
	
		Iterator<String> it = handles.iterator();
		String parentWindow =  it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindow);
		WebElement nameTextBox = driver.findElement(By.cssSelector("[name='name']"));
		nameTextBox.sendKeys(courseName);
		
		//Capture screenshot of webelement textbox
		File file = nameTextBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File ("C:\\SeleniumFiles\\screenshots\\screenshot.png"));
		
		//Get the height and width of webelement - name text box.
		int height = nameTextBox.getRect().getDimension().getHeight();
		
		int width = nameTextBox.getRect().getDimension().getWidth();
		System.out.println("Height=" +height +" Width="+width);	
		
	}

}
