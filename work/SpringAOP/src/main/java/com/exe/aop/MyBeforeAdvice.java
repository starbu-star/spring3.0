package com.exe.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyBeforeAdvice {

	@Before("execution(public void com..aop.*.*(..))")
	//�����̽� >> ������ �ڵ�
	//��� �������� ����Ʈ��
	public void beforeMethodCall() {
		System.out.println("�޼ҵ� ���� ��(Before Advice)");
	}
	
}