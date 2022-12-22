package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day1 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("No matter defined me anywhere in any test I will execute before suite.");
		
	}

	@BeforeClass
	public void beforeClass(){
		System.out.println("EXecutes before the methods in this class");	
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("I will execute first in tests");
	}
	
	@BeforeMethod
	public void bfMethod(){
		System.out.println("I will execute before every method in this class.");
		
	}
	
	
	@Test(groups={"Welcome"})
	public void test1() {
		System.out.println("Hello");
	}
	
	
	@Test
	public void test2() {
		System.out.println("Bye");
	}
	
	
	@AfterMethod
	public void afMethod() {
		System.out.println("I will execute after every method in this class.");
	}
	
	
	@AfterClass
	public void afterClass() {
		System.out.println("Executes at the end of all the methods in this class.");
	}
}
