package com.exe.springdi3;

public interface Message {
	
	//스프링은 의존성 약하게 하기위해 인터페이스 사용
	public void sayHello(String name); //아까처럼 메소드만 정의해둠

}
