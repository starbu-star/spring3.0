package com.exe.board;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringBootBoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	@Test
	void contextLoads()  {
	}
	/*
	@Test
	void save() {
		
		Question q1= new Question();
		q1.setSubject("스프링 부트가 무엇인가요?");
		q1.setContent("스프링 너무 어려워엽..");
		q1.setCreatedDate(LocalDateTime.now());
		
		this.questionRepository.save(q1);
		
		Question q2= new Question();
		q2.setSubject("JAP가 무엇인가요?");
		q2.setContent("JPA 너무 어려워엽..");
		q2.setCreatedDate(LocalDateTime.now());
		
		this.questionRepository.save(q2);
		
		
	}
	*/
	
	@Test
	void findAll() {
		List<Question> lists = questionRepository.findAll();//모든데이터를 리스트에 넣어
		
		assertEquals(2,lists.size());
		
		Question q = lists.get(0);
		assertEquals("스프링 부트가 무엇인가요?",q.getSubject());
		
	}
	@Test 
	void findBySubject() {
		Question q =questionRepository.findBySubject("스프링 부트가 무엇인가요?");
		
		assertEquals(2, q.getId());
	}

}
