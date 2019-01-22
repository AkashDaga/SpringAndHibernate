package com.example.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyApiAnalyticsAspect {
	
	@Before("com.example.springAOP.aspect.PointCutExpressionsUtils.forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("====> Executing @Before advice Performing API analytics");
	}

}
