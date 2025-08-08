package org.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


	public  Properties init_Prop() {
		try {
			FileInputStream fis = new FileInputStream ("./src/test/resources/Configuration/Config.properties" );
			Properties prop = new Properties();

			prop.load(fis);
			//System.out.println("prop"+prop);
			return prop ;

		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public  String getTestData (String key) {
		try {
			FileInputStream fis = new FileInputStream ("./src/test/resources/Configuration/Config.properties");


			Properties prop = new Properties();
			prop.load(fis);
			System.out.println("prop "+prop.getProperty(key));
			return prop.getProperty(key);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
