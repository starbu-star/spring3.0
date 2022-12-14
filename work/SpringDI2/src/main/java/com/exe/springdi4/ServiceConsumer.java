package com.exe.springdi4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component ("serviceConsumer")
public class ServiceConsumer {
	/**완충기능*/
	/**public void consumerService() {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		MessageService ms = 
				(MessageService)context.getBean("messageService");
		String message = ms.getMessage();
		
		System.out.println(message);
	
	
	}*/

	/**이제는 생성자가 필요없어짐*/
	@Autowired
	@Qualifier("messageService")//정확히 이 이름과 일치하는 애 가지고와
	MessageService ms ; 
	@Autowired
	TimeService ts;
	@Autowired
	JobService js;
	
	public void consumerService() {
		/**생성자로 의존성 주입*/
		String message = ms.getMessage();
		System.out.println(message);
		
		/**메소드로 의존성 주입*/
		String time = ts.getTimeString();
		System.out.println(time);
		
		js.getJob(); //자체적으로 syso를 가지고 있어서 이렇게만 하면 출력됨.
	}
}
