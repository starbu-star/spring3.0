package com.exe.springdi4;

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
	/**�����ڷ� ������ ����*/
	MessageService ms ;
	TimeService ts;
	JobService js;
	
	/**�̰� �⺻ ������ ���� �޼ҵ�� ������ �����Ҷ��� �� �ʿ�
	 * ������ �⺻������ �����ص� ���´�. 
	 * ������ app-context*/
	public ServiceConsumer() {}
	
	
	public ServiceConsumer(MessageService ms) {
		this.ms = ms;
	}
	
	/**�޼ҵ�� ������ ����
	 * �⺻�����ڷ� ������ ���� �޼ҵ�� ����*/
	public void setTimeService(TimeService ts) {
		this.ts = ts;
	}
	
	public void setJobService(JobService js) {
		this.js = js;
	}
	
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