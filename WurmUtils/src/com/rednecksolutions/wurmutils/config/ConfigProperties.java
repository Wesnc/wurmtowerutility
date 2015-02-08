package com.rednecksolutions.wurmutils.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigProperties 
{
	Properties configProperties = null;
	
	public ConfigProperties()
	{
		loadProperties();
	}
	
	public void loadProperties()
	{
		File pFile = new File(Constants.PROPERTIES_DIR+Constants.PROPERTIES_FILENAME);
		System.out.println(pFile.getAbsolutePath());
		if(!pFile.exists())
		{
			if(Constants.DEBUG)
				System.out.println("Configuration File Doesn't exist. Creating...");
			
			OutputStream out = null;
			try
			{
				configProperties = new Properties();
				configProperties.setProperty(Constants.PROPERTY_TWITTER_ACCESSTOKEN, "");
				configProperties.setProperty(Constants.PROPERTY_TWITTER_ACCESSTOKENSECRET, "");
				configProperties.setProperty(Constants.PROPERTY_TWITTER_CONSUMERKEY, "");
				configProperties.setProperty(Constants.PROPERTY_TWITTER_CONSUMERSECRET, "");
				configProperties.setProperty(Constants.PROPERTY_WURM_DIRECTORY, "");
				configProperties.setProperty(Constants.PROPERTY_WURM_CHARACTER, "");
				
				out = new FileOutputStream(pFile.getAbsolutePath());
				configProperties.store(out, "Default Generated User Configuration");
			}
			catch(IOException ex) { ex.printStackTrace(); }
		}
		else
		{
			if(Constants.DEBUG)
				System.out.println("Configuration File Does exist. Loading...");
			
			try
			{
				FileInputStream is = new FileInputStream(pFile);
				configProperties = new Properties();
				configProperties.load(is);
				
				Constants.TWITTER_ACCESSTOKEN = configProperties.getProperty(Constants.PROPERTY_TWITTER_ACCESSTOKEN);
				Constants.TWITTER_ACCESSTOKENSECRET = configProperties.getProperty(Constants.PROPERTY_TWITTER_ACCESSTOKENSECRET);
				Constants.TWITTER_CONSUMERKEY = configProperties.getProperty(Constants.PROPERTY_TWITTER_CONSUMERKEY);
				Constants.TWITTER_CONSUMERKEYSECRET = configProperties.getProperty(Constants.PROPERTY_TWITTER_CONSUMERSECRET);
				Constants.WURM_DIRECTORY = configProperties.getProperty(Constants.PROPERTY_WURM_DIRECTORY);
				Constants.WURM_CHARACTER = configProperties.getProperty(Constants.PROPERTY_WURM_CHARACTER);
				Constants.WURM_FULLPATH = Constants.WURM_DIRECTORY+"\\players\\"+Constants.WURM_CHARACTER+"\\logs\\";
				Constants.WURM_LOGPATH = Constants.WURM_FULLPATH+Constants.WURM_LOGTYPE;
				
				is.close();
			}
			catch(IOException ex) { ex.printStackTrace(); }
		}
	}
	
	public static void main(String[] args)
	{
		ConfigProperties config = new ConfigProperties();
	}
}
