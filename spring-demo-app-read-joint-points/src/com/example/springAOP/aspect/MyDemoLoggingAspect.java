package com.example.springAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.springAOP.dao.Account;

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
@Order(1)
public class MyDemoLoggingAspect {
	
//	@Before("forDaoPackage() || setter() || getter()") // it will fire up all the method starts with anything , get and set
	@Before("com.example.springAOP.aspect.PointCutExpressionsUtils.forDaoPackage() && !com.example.springAOP.aspect.PointCutExpressionsUtils.setter() && !com.example.springAOP.aspect.PointCutExpressionsUtils.getter()") // it will fire up all the method starts with anything but not with get and set
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature)(joinPoint.getSignature());
		
		System.out.println("====> Executing @Before advice on AddAccount "+methodSignature);
		
		Object[] args = joinPoint.getArgs();
		
		for(Object tempArgs : args) {
			if(tempArgs instanceof Account) {
			Account account = (Account) tempArgs;
			System.out.println("Arguments ---> "+account.getName());
			System.out.println("Arguments ---> "+account.getLevel());
			}
		}
		
	}
}
