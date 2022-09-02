package com.exe.board.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.exe.board.DataNotFoundException;

import lombok.RequiredArgsConstructor;

//controller->service ->repository다이렉트로 접근했다.
@RequiredArgsConstructor //파이널 사용될수있게 생성자 처리해주는거
@Service
public class QuestionService {

	private final QuestionRepository questionRepository;
	
	public Page<Question> getList(Pageable pageable){
		
		List<Sort.Order> sorts = new ArrayList<Sort.Order>();
		
		sorts.add(Sort.Order.desc("createdDate"));
		
		pageable =PageRequest.of(pageable.getPageNumber() <=0 ? 0 :pageable.getPageNumber() -1,
				pageable.getPageSize(),Sort.by(sorts));
		
		//getPageNumber : 반환할 페이지
		//etPageSize : 반환할 항목수
		//PageRequest :정렬 매개변수가 적용된 새로운 항목을 생성
		return questionRepository.findAll(pageable);
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> op = questionRepository.findById(id);//하나의 데이터 읽어옴
		if(op.isPresent())
			return op.get();
		else 
			throw new DataNotFoundException("데이터가 없어요.");
		
	}
	public void create(String subject,String content) {
		
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreatedDate(LocalDateTime.now());
		
		questionRepository.save(q);
	}
	
}
