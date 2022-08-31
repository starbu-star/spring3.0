package com.exe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class MyAroundAdvice {
	@Around("execution(public void com..aop.*.*(..))")
	public Object aroundMethodCall(ProceedingJoinPoint joinPoint) {
		
		Object result = null;
		
		try {
			System.out.println("메소드 실행전(Around Before)");
			result = joinPoint.proceed();
			System.out.println("메소드 실행후(Around After)");
		} catch (Throwable e) {//얘는 반드시 throwable 로 처리 해줘야한다.
			System.out.println(e.toString());
		}
		return result;
	}
}
