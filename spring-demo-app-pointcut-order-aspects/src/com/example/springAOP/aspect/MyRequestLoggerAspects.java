package com.example.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(4)
public class MyRequestLoggerAspects {
	
	@Before("com.example.springAOP.aspect.PointCutExpressionsUtils.setter()")
	public void logRequests() {
		System.out.println("====> Executing @Before advice logging to requests");
	}

}
