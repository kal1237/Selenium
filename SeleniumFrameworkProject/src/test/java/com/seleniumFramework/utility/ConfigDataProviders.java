package com.seleniumFramework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProviders {
	Properties pro;
	public ConfigDataProviders()
	{
		File src=new File("./Config/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to load config file "+e.getMessage());
		}
		
	}
	
	public String getDataFromConfig(String KeytoSearch)
	{
		return pro.getProperty(KeytoSearch);
	}

	
	public String getBrowser()
	{
		
		return pro.getProperty("Browser");
	}

	public String getURL()
	{
		return pro.getProperty("qaURL");
	}
	
}
