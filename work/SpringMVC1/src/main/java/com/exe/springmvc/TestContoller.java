package com.exe.springmvc;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
/**testcontroller 의 객체생성*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("test.controller")
public class TestContoller {
	/*
	 * @RequestMapping(value = "/test/param.action",method = RequestMethod.GET)
	 * public String processGetRequest() {
	 * 
	 * 
	 * System.out.println("Get 방식의 Request");
	 * 
	 * return "paramResult"; //paramResult.jsp로 가라! }
	 * 
	 * @RequestMapping(value = "/test/param.action" ,method = RequestMethod.POST)
	 * public String processPostRequest() { System.out.println("Post 방식의 Request");
	 * 
	 * return "paramResult"; //paramResult.jsp로 가라! }
	 */

	@RequestMapping(value = "/test/param.action", method = { RequestMethod.GET, RequestMethod.POST })
	public String processRequest(String name,HttpServletRequest request,PersonDTO dto) {
		System.out.println("Get/Post 방식 request ");
		
		System.out.println(name);
		System.out.println(request.getParameter("phone"));
		System.out.println(dto);
		System.out.println("name:"+dto.getName());
		System.out.println("phone:"+dto.getPhone());
		System.out.println("email:"+dto.getEmail());
		return "paramResult";
	}
	@RequestMapping(value ="/test/mav.action", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mavRequest(PersonDTO dto) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.setViewName("paramResult");
		
		return mav;
	}
	
	@RequestMapping(value ="/test/redirect.action", method = {RequestMethod.GET, RequestMethod.POST})
	public String mavRedirectRequest() {
		/* return "redirect:/"; */
	
	return "redirect:hello.action";
	/* return "hello"; 위와는 다르다!*/
	}
	
		
}
