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
@Entity //JPA�� �޼ҵ� �ȿ� ����� ������ ���̺�� ����鼭 ��Ī�� ��Ŵ
//JPA�� ��ƼƼ�� �ν�
public class Question {
	
	@Id//�̷��� primary key �ش�.
	@GeneratedValue(strategy = GenerationType.IDENTITY)//1�� �����ϴ� ������ �ڵ����� ����
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")//������ ���� �������� ������ ���
	private String content;
	
	private LocalDateTime createdDate;
	
	@OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE
			,fetch = FetchType.EAGER) //�ϳ��� ������ �������� �亯�� �޸��� �����ϱ�
	//�⺻ ����Ʈ�� lazy �� ���ŷ� �ٲٸ� ���� ���� �ȴ�. 
	private List<Answer> answerList;

}
