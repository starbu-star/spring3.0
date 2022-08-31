package com.exe.springdi4;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("messageService") //이렇게 이름 지정 안하면 MyMessageService 로 만들어짐
@Scope(value ="prototype") //이 메소드가 실행되는 영역에서만 메세지를 호출해라
public class MyMessageService implements MessageService{

	public String getMessage() {
		
		return "안녕 오늘은 불금이얍";
	}

}
