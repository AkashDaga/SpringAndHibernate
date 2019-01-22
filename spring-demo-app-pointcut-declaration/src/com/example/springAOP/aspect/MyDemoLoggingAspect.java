package com.example.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @author akash
 * 
 * aspects doesn't have any order by default, any aspect can run at any time, for ordering the aspects we need
 * to specify the order , the lowest number has the highest priority, negative numbers are also accepted ,
 * if any two aspects having same order then any one of them can run first
 *
 */
@Aspect
@Component
public class MyDemoLoggingAspect {
	/**
	 *  point cut declaration , we can use this declaration syntax if same kind of point cut expression 
	 *  is used for various methods 
	 */
	
	@Pointcut("execution(* com.example.springAOP.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.example.springAOP.dao.*.get*(..))")
	public void getter() {
		System.out.println("====> Executing @Before advice on getter ");
	}
	
	@Pointcut("execution(* com.example.springAOP.dao.*.set*(..))")
	public void setter() {
		System.out.println("====> Executing @Before advice on setter");
	}
	
//	@Before("forDaoPackage() || setter() || getter()") // it will fire up all the method starts with anything , get and set
	@Before("forDaoPackage() && !setter() && !getter()") // it will fire up all the method starts with anything but not with get and set
	public void beforeAddAccountAdvice() {
		System.out.println("====> Executing @Before advice on AddAccount");
	}
	
//	@Before("forDaoPackage()")
//	public void performApiAnalytics() {
//		System.out.println("====> Executing @Before advice Performing API analytics");
//	}
}
