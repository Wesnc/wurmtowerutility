package com.rednecksolutions.wurmutils.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

import com.rednecksolutions.wurmutils.config.Constants;

public class TwitterUtil 
{
	Twitter twitter = new TwitterFactory().getInstance();;
	
	public void postToTwitter(String msg)
	{
		try {
			System.out.println("Posting to twitter: "+msg);
			twitter.updateStatus(msg);
		} 
		catch (TwitterException e) { e.printStackTrace(); }
	}
	
}
