package com.example.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author akash Point Cut Expression Language, inside execution whatever we
 *         will write it will tell the spring container how when and where these
 *         advice needs to be fired up
 * 
 *         execution(modifiers-pattern? return type pattern
 *         declaring-type-pattern? method-name-pattern(param pattern)
 *         throws-pattern)
 * 
 *         modifiers-pattern -> Spring AOP only takes public or *
 *         declaring-type-pattern -> Class name ? ---> its optional pattern --->
 *         we can use wild cards also
 *         
 *         parameter pattern ---> ()   matches method with no argument
 *         						  (*)  matches method with one argument of any type
 *                                (..) matches method with one or more argument of any type
 *                                
 *         we can define package name also ---> "execution(* com.example.springAOP.dao.*.*(..))"
 *
 */

@Aspect
@Component
public class MyDemoLoggingAspect {
//	@Before("execution(public void addAccount())") //executes before addAccount with no args of any class and returns void, 

//	@Before("execution(public void com.example.springAOP.dao.AccountDao.addAccount())") // executes before only
																						// AccountDao addAccount method with no args
																						// fired up and returns void,  
	
//	@Before("execution(public void add*())") //executes before any method starts with add with no args and returns void
//	@Before("execution(public void add*())") //executes before any method starts with add with no args and returns void
//	@Before("execution(public * add*())") //executes before any method starts with add with no args and returns anything
//	@Before("execution(public * add*(com.example.springAOP.demo.Account)") //executes before any method starts with add with param Account and returns anything
//	@Before("execution(public * add*(com.example.springAOP.demo.Account, boolean))") //executes before any method starts with add with param Account and boolean and returns anything
//	@Before("execution(public * add*(..))") //executes before any method starts with add with param anything and returns anything
	@Before("execution(* com.example.springAOP.dao.*.*(..))") //executes before any method inside dao package starts with add with param anything and returns anything
	public void beforeAddAccountAdvice() {
		System.out.println("====> Executing @Before advice on AddAccount");
	}
}
