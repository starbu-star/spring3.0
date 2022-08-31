package com.exe.springmybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		CustomDAO dao = (CustomDAO)context.getBean("customDAO"); //customDAO 라는 bean줘봐
		
		CustomDTO dto;
		
		
		
		// insert
		
//		dto=new CustomDTO();
//		dto.setId(333);
//		dto.setName("전지현");
//		dto.setAge(45);
//		
//		dao.insertData(dto);
//		System.out.println("들어갔답");
//	
		//수정
//		dto= new CustomDTO();
//		dto.setId(111);
//		dto.setName("안젤리");
//		dto.setAge(30);
//		
//		dao.updateDate(dto);
//		System.out.println("바꿔버렸답");
	
		//delete
		
//		dao.deleteData(111);
		
		/**하나의데이터 */
		dto=dao.getReadData(111);
		if(dto!=null) {
			System.out.printf("%d %s %d \n", dto.getId(),dto.getName(),dto.getAge());
		}
		System.out.println("하나의 데이터 나오게 했땁!");
		
		/**list*/
		List<CustomDTO> lists = dao.getList();
		for(CustomDTO dto1 :lists) {
			System.out.printf("%d %s %d \n", dto1.getId(),dto1.getName(),dto1.getAge());
		}
		System.out.println("select 완료");
		
		
		
	}

}
