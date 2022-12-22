package introduction;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Get the total number of links on page.
		List<WebElement> List = driver.findElements(By.tagName("a"));
		int countOfLinksOnPage = List.size();
		System.out.println(countOfLinksOnPage);
		
		
		//Get the count of links present in footer of page.
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		List<WebElement> listOfFooterLinks = footerdriver.findElements(By.tagName("a"));
		int countOfFooterLinks = listOfFooterLinks.size();
		System.out.println(countOfFooterLinks);
		
		//Get the count of links available in first column of footer.
		WebElement footerColumndriver = driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
		List<WebElement> listOfColumnLinks = footerColumndriver.findElements(By.tagName("a"));
		int countOfColumnLinks = listOfColumnLinks.size();
		System.out.println(countOfColumnLinks);
		
		
		//Open every link from footer first column in new tab.
		for(int i=1; i<countOfColumnLinks; i++)
		{
			//To right click on link and open in new tab.
			String clickOnNewLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerColumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnNewLink);
			Thread.sleep(3000);
		}
		
		
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid...]
		java.util.Iterator<String> it = windows.iterator();
		
		while(it.hasNext()) {
		driver.switchTo().window(it.next());
//		System.out.println(driver.findElement(By.tagName("h1")).getText());
		System.out.println(driver.getTitle());
		
		}
		
	}

}
