package com.exe.springdi2;

public class MessageCall {

	public static void main(String[] args) {
		MessageKr ob1 = new MessageKr();
		ob1.sayHello("박지성");
		
		MessageEn ob2 = new MessageEn();
		ob2.sayHello("jisung");
		
		Message ms = null;
		
		ms = new MessageKr();
		ms.sayHello("인선");
		
		ms = new MessageEn();
		ms.sayHello("insun");
	}

}
