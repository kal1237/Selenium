package com.seleniumFramework.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.seleniumFramework.pages.BaseClass;
import com.seleniumFramework.pages.LoginPage;
import com.seleniumFramework.utility.BrowserFactory;

public class LoginTestCrm extends BaseClass{

	
	@Test
	public void loginApp()
	{
		LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
		lp.loginToPortal("Kalyani.thanikonda@gmail.com", "LearningIT123!");
		
		
	//initElements
	
	}
}
