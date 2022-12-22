package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Step:1 To select checkbox
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		// Step2 Get the text of selected checkbox and save in variable
		String selectedChBxText = driver.findElement(By.cssSelector("label[for='benz']")).getText().trim();
		System.out.println(selectedChBxText);
		// Select same value from dropdown
		WebElement dropdownIndex = driver.findElement(By.id("dropdown-class-example"));
		Thread.sleep(2000);
		Select dropdown = new Select(dropdownIndex);
		dropdown.selectByVisibleText(selectedChBxText);

		// Enter the value in text box
		driver.findElement(By.name("enter-name")).sendKeys(selectedChBxText);
		driver.findElement(By.id("alertbtn")).click();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);

		// Verify that alert message contains the selected option
		if (alertMessage.contains(selectedChBxText)) {
			
			System.out.println("The text contains the entered value");
			System.out.println(alertMessage.contains(selectedChBxText));
		}else {
			System.out.println("The text does not contain the selected value");
			System.out.println(alertMessage.contains(selectedChBxText));
		}
		
		driver.switchTo().alert().accept();

	}

}
