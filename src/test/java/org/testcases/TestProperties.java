package org.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		Logger logger =  (Logger) LogManager.getLogger(TestProperties.class);
		
		final Logger log = LogManager.getLogger(TestProperties.class);
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:/Users/Kc Cabelin/eclipse-workspace/MicrosoftPlaywright/src/test/resources/packages/locators.properties");
			prop.load(fis);
			log.info("Properties are loaded");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(prop.get("browser"));
		log.info("Browser Info has launched");
		System.out.println(prop.get("username_xPath"));
		

	}

}
