
package com.extractdata.test;


import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.extractdata.base.Base;
import com.extractdata.page.HomePage;
import com.extractdata.util.ReadConfig;
import com.extractdata.util.ReadExcel;
import com.extractdata.util.WriteExcel;

public class Testapp {

	WebDriver driver = null;
	File folder = null;
	Properties properties = ReadConfig.readConfig();
	@BeforeClass
	public void initialize() {
			
		folder = new File("downloads");
		folder.mkdir();
		driver = Base.getDriver(properties.getProperty("browser"),folder.getAbsolutePath());
		
		driver.get(properties.getProperty("url"));
	}
	
	
	@Test
	public void testOutput(){
		
		HomePage homePage = new HomePage(driver);
		homePage.customWait(5000);
		homePage.clickDownload();
		//Wait for file to be available
		homePage.customWait(5000);
		//Read the data provide in the downloaded file and write data in a file
		//To check folder is not empty
		Assert.assertTrue(folder.listFiles().length>0);
		for (File files:folder.listFiles()) {
			//To check if the file was actually downloaded
			Assert.assertTrue(files.length()>0);
		}
		WriteExcel.writeData(ReadExcel.readData());
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		//Delete the downloads folder
		for (File file:folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}
}
