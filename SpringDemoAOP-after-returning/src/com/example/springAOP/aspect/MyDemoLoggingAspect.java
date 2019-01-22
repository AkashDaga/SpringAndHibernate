package com.example.springAOP.aspect;

import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.springAOP.demo.Account;

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
	@AfterReturning(
			pointcut="execution(* com.example.springAOP.dao.AccountDao.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinpoint, List<Account> result) {
		String method = joinpoint.getSignature().toShortString();
		System.out.println("-----> executing afterReturningFindAccountsAdvice ");
		
		System.out.println("Result is ----> "+result);
		if(result != null) {
			for(Account tempAccount : result) {
				String upperCaseName = tempAccount.getName().toUpperCase();
				tempAccount.setName(upperCaseName);
			}
		}
		
		System.out.println("After Returning Demo App "+result);
	}
	
	
	@Before("execution(* com.example.springAOP.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("====> Executing @Before advice on AddAccount");
	}
}
