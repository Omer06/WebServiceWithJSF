package com.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
	
	private static final BuildLog succesfulBuildLog = new SuccesfulBuildLog();
	private static final BuildLog failBuildLog = new FailBuildLog();

	@AfterReturning("allDaoClasses()")
	public void succesfullLog(JoinPoint joinPoint) {
		StringBuilder log = succesfulBuildLog.build(joinPoint);
		System.out.println(log);
	}

	@AfterThrowing(pointcut = "allDaoClasses()", throwing = "exception")
	public void errorLog(JoinPoint joinPoint, Exception exception) {
		StringBuilder log = failBuildLog.build(joinPoint);
		log.append(" [ Exception Message :  " + exception.getMessage() +  "] ");
		System.err.println(log);
	}

	@Pointcut("within (com.imp.dao.*)")
	public void allDaoClasses() { }

}
