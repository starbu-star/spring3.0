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

//controller->service ->repository���̷�Ʈ�� �����ߴ�.
@RequiredArgsConstructor //���̳� ���ɼ��ְ� ������ ó�����ִ°�
@Service
public class QuestionService {

	private final QuestionRepository questionRepository;
	
	public Page<Question> getList(Pageable pageable){
		
		List<Sort.Order> sorts = new ArrayList<Sort.Order>();
		
		sorts.add(Sort.Order.desc("createdDate"));
		
		pageable =PageRequest.of(pageable.getPageNumber() <=0 ? 0 :pageable.getPageNumber() -1,
				pageable.getPageSize(),Sort.by(sorts));
		
		//getPageNumber : ��ȯ�� ������
		//etPageSize : ��ȯ�� �׸��
		//PageRequest :���� �Ű������� ����� ���ο� �׸��� ����
		return questionRepository.findAll(pageable);
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> op = questionRepository.findById(id);//�ϳ��� ������ �о��
		if(op.isPresent())
			return op.get();
		else 
			throw new DataNotFoundException("�����Ͱ� �����.");
		
	}
	public void create(String subject,String content) {
		
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreatedDate(LocalDateTime.now());
		
		questionRepository.save(q);
	}
	
}