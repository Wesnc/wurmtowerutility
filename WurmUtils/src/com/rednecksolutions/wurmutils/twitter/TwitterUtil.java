package com.rednecksolutions.wurmutils.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import com.rednecksolutions.wurmutils.config.Constants;

public class TwitterUtil 
{
	Twitter twitter = new TwitterFactory().getInstance();;
	
	public void postToTwitter(String msg)
	{
		if(Constants.DEBUG_TWITTER && Constants.TWITTER_ENABLED)
			System.out.println("Posting to twitter: "+msg);
		
		if(Constants.TWITTER_ENABLED)
			try { twitter.updateStatus(msg); } catch (TwitterException e) { e.printStackTrace(); }
	}
	
}
