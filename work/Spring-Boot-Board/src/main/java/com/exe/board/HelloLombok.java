package com.exe.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor //오버로딩된 생성자 만들기(this.name 이런거)
//오버로딩된 생성자 만들때 반드시 변수 파이널로 선언해야한다.
@Getter
@Setter
public class HelloLombok {
	
	private final String name;
	private final int age;
	
	/*
	public static void main(String[] args) {
		HelloLombok hk = new HelloLombok("유인나",40);

		
		 hk.setName("배수지");
		 hk.setAge(27);
		
		
		System.out.println(hk.getName());
		System.out.println(hk.getAge());
		*/
		
	

}
