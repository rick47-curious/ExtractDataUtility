package com.extractdata.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	
	
	public static Properties readConfig() {
		
		Properties prop = null;
		String basePath = System.getProperty("user.dir");
		FileInputStream fis;
		try {
			fis = new FileInputStream(basePath+"/src/test/resources/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
