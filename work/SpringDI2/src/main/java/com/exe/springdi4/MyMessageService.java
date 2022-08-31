package com.exe.springdi4;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("messageService") //�̷��� �̸� ���� ���ϸ� MyMessageService �� �������
@Scope(value ="prototype") //�� �޼ҵ尡 ����Ǵ� ���������� �޼����� ȣ���ض�
public class MyMessageService implements MessageService{

	public String getMessage() {
		
		return "�ȳ� ������ �ұ��̾�";
	}

}
