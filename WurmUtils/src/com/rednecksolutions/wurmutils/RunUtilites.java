package com.rednecksolutions.wurmutils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rednecksolutions.wurmutils.config.ConfigProperties;
import com.rednecksolutions.wurmutils.config.Constants;
import com.rednecksolutions.wurmutils.logging.LogHelper;
import com.rednecksolutions.wurmutils.logging.LogTailListener;
import com.rednecksolutions.wurmutils.twitter.TwitterUtil;
import com.rednecksolutions.wurmutils.ui.ConfigDialog;

public class RunUtilites 
{
	public static ConfigProperties props = new ConfigProperties();
	public static LogHelper logHelper;
	public static TwitterUtil twitter;
	
	public static ArrayList<String> initMessages = new ArrayList<String>();
	
	public static void main(String[] args)
	{
		System.out.println("\n----- Tower Basher Utility: "+Constants.VERSION+" -----\n");
		
		if(Constants.WURM_DIRECTORY.length() == 0)
		{
			ConfigDialog dialog = new ConfigDialog();
			dialog.setVisible(true);
		}
		else
		{
			SimpleDateFormat logDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = logDateFormat.format(new Date());
			Constants.WURM_LOGTYPE = "_Event."+dateString+".txt";
			Constants.WURM_LOGPATH = Constants.WURM_LOGPATH+Constants.WURM_LOGTYPE;
			
			System.out.println("Wurm Full Path: "+Constants.WURM_FULLPATH);
			System.out.println("Wurm Log Path: "+Constants.WURM_LOGPATH);
			
			File logFile = new File(Constants.WURM_LOGPATH);
			if(logFile.exists())
			{
				System.out.println("Event log found");
				System.out.println("Attaching log tailer...");
				logHelper = new LogHelper(logFile);

				try 
				{
					System.out.println("Initializing Twatter...");
					twitter = new TwitterUtil();
					twitter.postToTwitter("Tower Utility initialized ("+new Random().nextInt(100)+") Version: "+Constants.VERSION);
					
					while(true)
					{
						List<String> lines = LogTailListener.getLineArray();
						for(String line: lines)
						{
							Pattern r = Pattern.compile(Constants.TAILER_BASHMSG);
							Matcher m = r.matcher(line);
							
							if(m.find())
							{
								RunUtilites.twitter.postToTwitter("Warning!! Tower: "+m.group(1)+" is being bashed!! (RandomInt:"+new Random().nextInt(100));
								lines.remove(line);
								
								break;
							}
						}
					}
					
				} 
				catch(NullPointerException e) { e.printStackTrace(); }
			}
			else
				System.out.println("Error Finding log: "+Constants.WURM_LOGPATH);
		}
	}
}
