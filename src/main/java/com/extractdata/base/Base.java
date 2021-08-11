package com.extractdata.base;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public static WebDriver getDriver(String browserName,String filePath) {
		
		WebDriver driver = null;
		
		if (browserName.equalsIgnoreCase("chrome")) {
			//Creating a download path
			
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			//Creating a map to store preferences for chrome
			Map<String,Object> prefMap = new HashMap<String,Object>();
			//Handle download popup
			prefMap.put("profile.default_content_settings.popups", 0);
			//Handle download location
			prefMap.put("download.default_directory",filePath);
			
			//Adding preferences in the chrome option
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.setExperimentalOption("prefs", prefMap);
			
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
			desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
			
			chromeoptions.merge(desiredCapabilities);
			
			driver = new ChromeDriver(chromeoptions);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}else if (browserName.equalsIgnoreCase("edge")) {
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			
		}
		return driver;
	}
}
