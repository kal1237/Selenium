package com.seleniumFramework.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.seleniumFramework.utility.BrowserFactory;
import com.seleniumFramework.utility.ConfigDataProviders;

public class BaseClass {
	public WebDriver driver;
	public ConfigDataProviders config;
	
@BeforeSuite
	public void setUp()
	{
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getURL());
	}
	
@AfterSuite
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
}
