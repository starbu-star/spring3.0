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

	//�亯�� �����ϴ� ���̺�
	@Id
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createdDate;
	
	@ManyToOne
	private Question question;
	//�亯�� �ϳ��� ������ �������� �޸��� �ִ�.
	//�亯�� many�� �ǰ� ������ one�� �ȴ�.
	//Foreingn Key�� ����
	
	
	
}
