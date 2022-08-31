package com.exe.springdi4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component ("serviceConsumer")
public class ServiceConsumer {
	/**������*/
	/**public void consumerService() {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		MessageService ms = 
				(MessageService)context.getBean("messageService");
		String message = ms.getMessage();
		
		System.out.println(message);
	
	
	}*/

	/**������ �����ڰ� �ʿ������*/
	@Autowired
	@Qualifier("messageService")//��Ȯ�� �� �̸��� ��ġ�ϴ� �� ��������
	MessageService ms ; 
	@Autowired
	TimeService ts;
	@Autowired
	JobService js;
	
	public void consumerService() {
		/**�����ڷ� ������ ����*/
		String message = ms.getMessage();
		System.out.println(message);
		
		/**�޼ҵ�� ������ ����*/
		String time = ts.getTimeString();
		System.out.println(time);
		
		js.getJob(); //��ü������ syso�� ������ �־ �̷��Ը� �ϸ� ��µ�.
	}
}