package com.exe.board.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.exe.board.question.Question;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AnswerService {
	private final AnswerRepository answerRepository;
	
	public void created(Question question,String content) {
		
		Answer ans = new Answer();
		
		ans.setContent(content);
		ans.setCreatedDate(LocalDateTime.now());
		ans.setQuestion(question);
		answerRepository.save(ans); //이렇게 하면 답변이 들어간다.
	}
	
}
