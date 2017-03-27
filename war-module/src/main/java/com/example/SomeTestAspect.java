package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
public class SomeTestAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(SomeTestAspect.class);

	@Autowired
	private MyClass myClass;

	@Pointcut("execution(* com.example.SomeTest.someMethod())")
	public void interceptionSomeMethod() {
	}

	@Around("interceptionSomeMethod()")
	public String aroundinterceptionTestMethod(ProceedingJoinPoint pjp) throws Throwable {
		return myClass.getString() + " :Aspect: " + pjp.proceed();
	}

}
