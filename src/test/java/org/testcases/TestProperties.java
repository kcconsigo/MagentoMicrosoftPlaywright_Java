package org.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:/Users/Kc Cabelin/eclipse-workspace/MicrosoftPlaywright/src/test/resources/packages/locators.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(prop.get("browser"));
		System.out.println(prop.get("username_xPath"));
		

	}

}
