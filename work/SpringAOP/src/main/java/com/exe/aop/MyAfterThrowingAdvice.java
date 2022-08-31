package com.exe.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterThrowingAdvice {
	@AfterThrowing("execution(public void com..aop.*.*(..))")
	public void afterThrowingMethodCall() {
		//에러가 나야 이게 나온답
		System.out.println("메소드 에러 발생후 실행(aftef throw)");
	}

}
