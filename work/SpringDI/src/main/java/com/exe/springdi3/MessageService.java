package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageService {
	
	public void messageService() {
		
		//app-context �� �о���� ���� �ڵ����� ��ü �����ǰ� �ҰŴ�
		
		//beanFactory ����
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		//Bean ȹ��
		
		Message ms = (Message)context.getBean("message"); //��������,�������̶� �������̽��� �ٿ�ĳ�����ϱ�!
		
		ms.sayHello("������");
		
	}

}