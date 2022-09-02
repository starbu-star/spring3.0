package com.exe.board.question;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.exe.board.answer.Answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //JPA가 메소드 안에 만드는 변수를 테이블로 만들면서 매칭을 시킴
//JPA가 엔티티로 인식
public class Question {
	
	@Id//이렇게 primary key 준다.
	@GeneratedValue(strategy = GenerationType.IDENTITY)//1씩 증가하는 고유값 자동으로 넣음
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")//글자의 수를 제한하지 않을때 사용
	private String content;
	
	private LocalDateTime createdDate;
	
	@OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE
			,fetch = FetchType.EAGER) //하나의 질문에 여러개가 답변이 달릴수 있으니까
	//기본 디폴트가 lazy 라서 에거로 바꾸면 정상 실행 된다. 
	private List<Answer> answerList;

}
