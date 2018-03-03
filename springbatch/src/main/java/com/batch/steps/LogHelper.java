package com.batch.steps;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class LogHelper {

	//@Before
	public void logReader() {
		
		System.out.println("Reader method is called !! ");
	}
	
	
}
