package com.batch.steps;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class LogHelper {

	
	@Pointcut("execution(* AspectTester.*(..))")  
    public void k(){}//pointcut name  
	
	
	
	@Before("execution(* com.batch.steps.TempReader *(..))")
	public void logReader(JoinPoint join) {
		System.out.println(join.getSignature().getName());
		System.out.println("Reader method is called !! ");
	}
	
	
	@Before("execution(*com.batch.steps.TempWriter.write(..))")
	public void logWriter(JoinPoint joinPoint) {
		System.out.println("This is writer method logging ");
	}
	
	@Before("execution(*com.batch.aspect.AspectTester.(..))")
	public void logAspectTester(JoinPoint joinPoint) {
		System.out.println("This is LogAspectTester method logging ");
	}
	
	
}
