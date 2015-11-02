package com.rednecksolutions.wurmutils.config;


public class Constants 
{
	public static String VERSION = "0.0.2b";
	
	//HOME VARIABLES
	public static String USER_OS = System.getProperty("os.name").toLowerCase();
	public static String USER_OS_SEP = System.getProperty("file.separator");
	public static String USER_HOME = System.getProperty("user.home");
	
	//Debug Variables
	public static boolean DEBUG = true;
	public static boolean DEBUG_TWITTER = true;
	
	//LogHelper Vars
	public static boolean TAILER_VERBOSE = false;
	public static String TAILER_BASHMSG = "Guard tower of (\\w+ \\d+) is under attack!";
	
	public static boolean TWITTER_ENABLED = true;
	public static String TWITTER_CONSUMERKEY = "";
	public static String TWITTER_CONSUMERKEYSECRET = "";
	public static String TWITTER_ACCESSTOKEN = "";
	public static String TWITTER_ACCESSTOKENSECRET = "";
	
	public static String WURM_DIRECTORY = "";
	public static String WURM_CHARACTER = "";
	public static String WURM_LOGTYPE = "";
	public static String WURM_LOGPATH = "";
	public static String WURM_FULLPATH = "";
	
	//PROPERY File Config
	public static String PROPERTIES_FILENAME = "config.properties";
	public static String PROPERTIES_DIR = USER_HOME+USER_OS_SEP+"WurmUtils"+USER_OS_SEP;
	public static String PROPERTY_WURM_DIRECTORY = "wurm.dir";
	public static String PROPERTY_WURM_CHARACTER = "wurm.character";
	
}
