package com.fastcampus.ch2;
//1.원격 호출 가능한 프로그램으로 등록

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	
	@RequestMapping("/hello")
	public void main() {
		
		System.out.println("Hello!");
	}
	

}
