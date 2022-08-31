package com.exe.aop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		TargetA ta = (TargetA)context.getBean("targetA"); //targetA가지고 오라고 호출
		
		ta.doSomething1();
		ta.doSomething2();
		ta.doAnother1();
		ta.doAnother2();
		
	TargetB tb = (TargetB)context.getBean("targetB"); //targetA가지고 오라고 호출
			
		tb.doSomething1();
		tb.doSomething2();
		tb.doAnother1();
		tb.doAnother2();

	}

}
