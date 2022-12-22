package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Day3 {

	@Test
	public void test3() {
		System.out.println("Ello");
	}
	
	@AfterSuite
	public void afSuite() {
		System.out.println("Define me in any test I will execute at last in suite.");
	}
}
