package com.rednecksolutions.wurmutils.logging;

import java.io.File;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;

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
