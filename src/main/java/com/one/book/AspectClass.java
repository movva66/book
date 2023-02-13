package com.one.book;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectClass {

	//private long startTime;
	private final static Logger LOGGER = LoggerFactory.getLogger(AspectClass.class);
	
//	@Before("execution (* com.one.book.*.*(..))")
//	public void beforeMethod(JoinPoint jp) {
//		String methodName = jp.getSignature().getName();
//		String className= jp.getTarget().getClass().toString();
//		LOGGER.info("Entered into method "+methodName + " of the "+className);
//	}
//	@After("execution (* com.one.book.*.*(..))")
//	public void afterMethod(JoinPoint jp) {
//		String methodName = jp.getSignature().getName();
//		String className= jp.getTarget().getClass().toString();
//	 LOGGER.info("Exit from method."+methodName + " of the "+className);
//	}
	
	@Around("execution(* com.one.book.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		LOGGER.info("==============================");

		 String methodName = pjp.getSignature().getName();
		 String className = pjp.getTarget().getClass().toString();
		 LOGGER.info("methodName==="+methodName);
		 LOGGER.info("className==="+className);

		 long  startTime = System.currentTimeMillis();
		
		 Object ob= pjp.proceed();
		 String methodName1 = pjp.getSignature().getName();
		 String className1 = pjp.getTarget().getClass().toString();
		 LOGGER.info("methodName==="+methodName1);
		 LOGGER.info("className==="+className1);
		 long endTime = System.currentTimeMillis(); 
		 
		 long time = endTime-startTime; 
		 LOGGER.info("Time taken to execute the method "+methodName+"of the "+className+"  is==> "+time);
			LOGGER.info("==============================");

		 return ob;
    }

}