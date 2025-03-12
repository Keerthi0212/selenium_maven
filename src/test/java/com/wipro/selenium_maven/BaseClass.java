package com.wipro.selenium_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	static WebDriver driver;
	public void invokeBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
	}

}
