package com.exe.springdi4;

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
	/**생성자로 의존성 주입*/
	MessageService ms ;
	TimeService ts;
	JobService js;
	
	/**이게 기본 생성자 생성 메소드로 의존성 주입할때는 꼭 필요
	 * 지금은 기본생성자 생략해도 나온다. 
	 * 이유는 app-context*/
	public ServiceConsumer() {}
	
	
	public ServiceConsumer(MessageService ms) {
		this.ms = ms;
	}
	
	/**메소드로 의존성 주입
	 * 기본생성자로 생성한 다음 메소드로 주입*/
	public void setTimeService(TimeService ts) {
		this.ts = ts;
	}
	
	public void setJobService(JobService js) {
		this.js = js;
	}
	
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
