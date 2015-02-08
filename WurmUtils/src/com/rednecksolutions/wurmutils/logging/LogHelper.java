package com.rednecksolutions.wurmutils.logging;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;

import com.rednecksolutions.wurmutils.config.Constants;

public class LogHelper
{
	TailerListener listener;
	Tailer tailer;
	File file;
	
	public LogHelper(File file)
	{
		this.file = file;
		
		listener = new LogTailListener();
		tailer = Tailer.create(file, listener, 100);
		
		System.out.println("Attaching");
	}
	
}
