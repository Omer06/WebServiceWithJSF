package com.log;

import org.aspectj.lang.JoinPoint;

public interface BuildLog {
	
	public StringBuilder build(JoinPoint joinPoint);
	
}

