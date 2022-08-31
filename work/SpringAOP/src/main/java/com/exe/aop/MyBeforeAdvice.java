package com.exe.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyBeforeAdvice {

	@Before("execution(public void com..aop.*.*(..))")
	//어드바이스 >> 내가할 코딩
	//어디에 적용할진 포인트컷
	public void beforeMethodCall() {
		System.out.println("메소드 실행 전(Before Advice)");
	}
	
}
