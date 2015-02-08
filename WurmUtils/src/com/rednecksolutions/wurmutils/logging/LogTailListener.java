package com.rednecksolutions.wurmutils.logging;

import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;

import com.rednecksolutions.wurmutils.config.Constants;

public class LogTailListener implements TailerListener
{
	static CopyOnWriteArrayList<String> lineArray = new CopyOnWriteArrayList<String>();
	
	@Override public void handle(String line) { 
		if(Constants.TAILER_VERBOSE)
			System.out.println(line);
		
		lineArray.add(line);
	}
	
	@Override public void fileNotFound() {
		try { throw new Exception("File Not found!"); } catch (Exception e) { e.printStackTrace(); }
	}
	@Override public void fileRotated() { }
	@Override public void handle(Exception ex) { }
	@Override public void init(Tailer arg0) { }
	
	public static CopyOnWriteArrayList<String> getLineArray() { return lineArray; }
	
}
