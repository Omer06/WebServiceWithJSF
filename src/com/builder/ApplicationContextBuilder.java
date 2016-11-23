package com.builder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextBuilder {
	
	 private static ApplicationContext applicationContext = null;
	 
	 public static ApplicationContext build() {
		 
		 if(applicationContext == null)
			 applicationContext = new ClassPathXmlApplicationContext("spring-general.xml");
		 
		 return applicationContext;
		 
	 }

}
