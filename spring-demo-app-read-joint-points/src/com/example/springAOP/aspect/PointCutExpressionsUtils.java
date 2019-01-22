package com.example.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutExpressionsUtils {
	/**
	 *  point cut declaration , we can use this declaration syntax if same kind of point cut expression 
	 *  is used for various methods 
	 */
	
	@Pointcut("execution(* com.example.springAOP.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.example.springAOP.dao.*.get*(..))")
	public void getter() {
		System.out.println("====> Executing @Before advice on getter ");
	}
	
	@Pointcut("execution(* com.example.springAOP.dao.*.set*(..))")
	public void setter() {
		System.out.println("====> Executing @Before advice on setter");
	}
}
