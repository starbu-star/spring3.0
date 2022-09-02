package com.exe.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {

	//답변을 저장하는 테이블
	@Id
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createdDate;
	
	@ManyToOne
	private Question question;
	//답변은 하나의 질문에 여러개가 달릴수 있다.
	//답변은 many가 되고 질문은 one이 된다.
	//Foreingn Key가 생성
	
	
	
}
