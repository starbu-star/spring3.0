package com.exe.board;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//@RestController 는 Controller + ResponseBody를 합친거
@RestController

public class HelloController {
	
	@RequestMapping("/hello")
	//@ResponseBody //text 띄울때 필요(@RestController 쓸땐 생략가능)
	public String hello() {
		return "hello Spring!";//text 
		
	}

}
