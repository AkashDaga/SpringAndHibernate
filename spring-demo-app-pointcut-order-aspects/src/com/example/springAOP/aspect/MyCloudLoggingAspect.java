package com.example.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyCloudLoggingAspect {
	
	
	@Before("com.example.springAOP.aspect.PointCutExpressionsUtils.getter()")
	public void logToCloudAsync() {
		System.out.println("====> Executing @Before advice logging to cloud aync");
	}
}
