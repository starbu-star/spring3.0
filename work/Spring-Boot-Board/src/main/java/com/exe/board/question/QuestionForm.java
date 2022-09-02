package com.exe.board.question;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {

	
	@NotEmpty(message = "������ �Է��ϼ���.")
	@Size(max=200)
	private String subject;
	@NotEmpty(message = "������ �Է��ϼ���")
	private String content;
	
	/*
	 * @Size		���� ���̸� �����Ѵ�.
@NotNull	Null�� ������� �ʴ´�.
@NotEmpty	Null �Ǵ� �� ���ڿ�("")�� ������� �ʴ´�.
@Past		���� ��¥�� ����
@Future		�̷� ��¥�� ����
@FutureOrPresent�̷� �Ǵ� ���ó�¥�� ����
@Max		�ִ밪
@Min		�ּҰ�
@Pattern	����ȭ ǥ�������� ����
	 * 
	 */

	
	
}
