package com.transaction;

import java.util.function.Consumer;
import java.util.function.Predicate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Transactioner {

	@Autowired
	@Qualifier("sessionFactoryImp")
	SessionFactory sessionFactory;

	@Around(value = "allDaoClasses()")
	public Object transaction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Session session = null;
		Object object = null;
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			object = proceedingJoinPoint.proceed();
			session.getTransaction().commit();
			
		}catch(Exception e) {
			System.err.println("Fail : ErrorMessage : " + e.getClass());
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.clear();
		}
		
		return object;
	}

	@Pointcut("within (com.imp.dao.*)")
	public void allDaoClasses() { }
	
	public void controlApply(Predicate<SessionFactory> condition , Consumer<SessionFactory> consumer , SessionFactory sessionFactory) {
		if(condition.test(sessionFactory)) { consumer.accept(sessionFactory); }
	}

}
