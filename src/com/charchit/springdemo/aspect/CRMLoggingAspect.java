package com.charchit.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	@Pointcut("(execution(* com.charchit.springdemo.controller.*.*(..)))")
	private void forControllerPackage() {}
	
	@Pointcut("(execution(* com.charchit.springdemo.service.*.*(..)))")
	private void forServicePackage() {}
	
	@Pointcut("(execution(* com.charchit.springdemo.dao.*.*(..)))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint point) {
		System.out.println(point.getSignature().toShortString());
	}
	
	@AfterReturning("forAppFlow()")
	public void after() {
		// System.out.println("After advice");
	}
}
