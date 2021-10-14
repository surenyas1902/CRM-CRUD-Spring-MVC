package com.surendiran.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup a logger
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.surendiran.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.surendiran.services.*.*(..))")
	private void forSerivcePackage() {
		
	}
	
	@Pointcut("execution(* com.surendiran.dao.*.*(..))")
	private void forDAOPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forSerivcePackage() || forDAOPackage()")
	private void forAppFlow() {
		
	}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String methodString = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>> in @Before: Calling method: " + methodString);
		
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArg : args) {
			System.out.println(tempArg.toString());
		}
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		String methodString = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>> in @Before: Calling method: " + methodString);
		myLogger.info(theResult.toString());
	}

}
