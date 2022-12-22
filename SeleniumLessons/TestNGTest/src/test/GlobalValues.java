package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValues {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		
		//FileInputStream class is use to read data from properties file.
		FileInputStream fip = new FileInputStream("C:\\SeleniumFiles\\SeleniumLessons\\TestNGTest\\src\\test\\data.properties");
		prop.load(fip);
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
		prop.setProperty("browser", "firefox");
		System.out.println(prop.getProperty("browser"));
		
		//FileOutputStream class is use to read data from properties file.
		FileOutputStream fop = new FileOutputStream("C:\\SeleniumFiles\\SeleniumLessons\\TestNGTest\\src\\test\\data.properties");
		prop.store(fop, null);
		
	}

}
