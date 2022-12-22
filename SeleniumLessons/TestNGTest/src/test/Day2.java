package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;  

public class Day2 {
	@Parameters({"URL"})
	@Test(groups={"Welcome"})
	public void test3(String url) {
		System.out.println("Tata");
		System.out.println(url);
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("I will execute last after all tests");
	}
	
	@Test(dataProvider = "getData")
	public void login(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}
	
	@DataProvider
	public Object[][] getData() {
		//1st combination username, password
		//2nd combination username, password
		//3rd combination username, password
		Object[][] data = new Object[3][2];
		data[0][0] = "firstUsername";
		data[0][1] = "firstPassword";
		data[1][0] = "secondUsername";
		data[1][1] = "secondPassword";
		data[2][0] = "thirdUsername";
		data[2][1] = "thirdPassword";
		
		return data;
		
	}
}
