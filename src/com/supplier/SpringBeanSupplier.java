package com.supplier;

import com.builder.ApplicationContextBuilder;

public class SpringBeanSupplier {
	
	public static <T> T supply(Class<T> clazz) {
		
		return ApplicationContextBuilder.build().getBean(clazz);
		
	}

}
