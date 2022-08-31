package com.exe.springmybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		CustomDAO dao = (CustomDAO)context.getBean("customDAO"); //customDAO ��� bean���
		
		CustomDTO dto;
		
		
		
		// insert
		
//		dto=new CustomDTO();
//		dto.setId(333);
//		dto.setName("������");
//		dto.setAge(45);
//		
//		dao.insertData(dto);
//		System.out.println("����");
//	
		//����
//		dto= new CustomDTO();
//		dto.setId(111);
//		dto.setName("������");
//		dto.setAge(30);
//		
//		dao.updateDate(dto);
//		System.out.println("�ٲ���ȴ�");
	
		//delete
		
//		dao.deleteData(111);
		
		/**�ϳ��ǵ����� */
		dto=dao.getReadData(111);
		if(dto!=null) {
			System.out.printf("%d %s %d \n", dto.getId(),dto.getName(),dto.getAge());
		}
		System.out.println("�ϳ��� ������ ������ �߶�!");
		
		/**list*/
		List<CustomDTO> lists = dao.getList();
		for(CustomDTO dto1 :lists) {
			System.out.printf("%d %s %d \n", dto1.getId(),dto1.getName(),dto1.getAge());
		}
		System.out.println("select �Ϸ�");
		
		
		
	}

}
