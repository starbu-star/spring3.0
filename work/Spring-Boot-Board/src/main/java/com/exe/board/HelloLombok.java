package com.exe.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor //�����ε��� ������ �����(this.name �̷���)
//�����ε��� ������ ���鶧 �ݵ�� ���� ���̳η� �����ؾ��Ѵ�.
@Getter
@Setter
public class HelloLombok {
	
	private final String name;
	private final int age;
	
	/*
	public static void main(String[] args) {
		HelloLombok hk = new HelloLombok("���γ�",40);

		
		 hk.setName("�����");
		 hk.setAge(27);
		
		
		System.out.println(hk.getName());
		System.out.println(hk.getAge());
		*/
		
	

}