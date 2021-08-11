package com.extractdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver = null;
	//private String uploadBtn = "//input[@name='upload_option']";
	private String downloadBtn = "//form[2]/button[1]";
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickDownload() {
		driver.findElement(By.xpath(downloadBtn)).click();
		
	}
	
	public void customWait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
