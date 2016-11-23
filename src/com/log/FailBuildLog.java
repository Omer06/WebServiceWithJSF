package com.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class FailBuildLog implements BuildLog {
	
	private StringBuilder log = new StringBuilder(100);
	private final static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");

	@Override
	public StringBuilder build(JoinPoint joinPoint) {
		
		log.setLength(0);
		log.append("Fail - [ ");
		log.append(date.format(new Date()) + " ]");
		log.append(" - [ " + joinPoint.getSignature().toString() + " ] - ");
		
		return log;
	}

}
