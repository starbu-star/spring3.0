package com.exe.springJdbcTemplate;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.exe.springJdbcTemplate.CustomDAO2;

public class CustomMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		CustomDAO2 dao = (CustomDAO2)context.getBean("customDAO2"); //customDAO ��� bean���
		
		CustomDTO dto;
		
		
		
		// insert
		
		dto=new CustomDTO();
		dto.setId(111);
		dto.setName("���γ�");
		dto.setAge(29);
		
		dao.insertData(dto);
		System.out.println("insert �Ϸ�");
	
		//����
//		dto= new CustomDTO();
//		dto.setId(111);
//		dto.setName("������");
//		dto.setAge(30);
//		
//		dao.updateDate(dto);
//		System.out.println("update �Ϸ�");
	
		//delete
		
//		dao.deleteData(111);
		
		/**�ϳ��ǵ����� 
		dto=dao.getReadData(111);
		if(dto!=null) {
			System.out.printf("%d %s %d \n", dto.getId(),dto.getName(),dto.getAge());
		}
		System.out.println("�ϳ��� ������ ������ �߶�!");
		*/
		/**list*/
		List<CustomDTO> lists = dao.getList();
		for(CustomDTO dto1 :lists) {
			System.out.printf("%d %s %d \n", dto1.getId(),dto1.getName(),dto1.getAge());
		}
		System.out.println("select �Ϸ�");
		
		
		
	}

}