package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageService {
	
	public void messageService() {
		
		//app-context 를 읽어오게 만들어서 자동으로 객체 생성되게 할거다
		
		//beanFactory 생성
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		//Bean 획득
		
		Message ms = (Message)context.getBean("message"); //꺼내오기,스프링이라 인터페이스로 다운캐스팅하기!
		
		ms.sayHello("박지성");
		
	}

}
