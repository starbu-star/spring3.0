package com.jdbc.springweb;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jdbc.dao.BoardDAO2;
import com.jdbc.dto.BoardDTO;
import com.jdbc.util.MyPage;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardDAO2")
	BoardDAO2 dao;
	
	@Autowired
	MyPage myPage;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
		
		return "index";
	}
	/*
	@RequestMapping(value = "/created.action", method = RequestMethod.GET)
	public String created() throws Exception{
		
		return "bbs/created";
		
	}*/
	
	@RequestMapping(value = "/created.action")
	public ModelAndView created() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("bbs/created");
		
		return mav;
		
	}
	@RequestMapping(value = "/created_ok.action",method = RequestMethod.POST)
	public String created_ok(BoardDTO dto,HttpServletRequest request)throws Exception{
		//최대값 구하고
		int maxNum = dao.getMaxNum();
		
		dto.setNum(maxNum +1);
		dto.setIpAddr(request.getRemoteAddr());
		
		dao.insertData(dto);
		
		return "redirect:/list.action";
	}
	
	@RequestMapping(value = "/list.action",method = {RequestMethod.POST , RequestMethod.GET})
	public String list(HttpServletRequest request)throws Exception{
		
		String cp = request.getContextPath();
				
			String pageNum = request.getParameter("pageNum");
		int currentPage = 1;
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");

		if (searchValue == null) {
			searchKey = "subject";
			searchValue = "";

		} else {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
		}

		int dataCount = dao.getDataCount(searchKey, searchValue);
		int numPerPage = 5;

		int totalPage = myPage.getPageCount(numPerPage, dataCount);

		if (currentPage > totalPage) {
			currentPage = totalPage;
		} // 이건 삭제했을떄 문제가 생길수 있어서

		// 이렇게하면 내가 가져올 rownum 시작 끝값 정해짐
		int start = (currentPage - 1) * numPerPage + 1;
		int end = currentPage * numPerPage;

		List<BoardDTO> lists = dao.getLists(start, end, searchKey, searchValue);

		String param = "";
		if (searchValue != null && !searchValue.equals("")) {
			param = "searchKey=" + searchKey;
			param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}

		String listUrl = cp + "/list.action";
		if (!param.equals("")) {
			listUrl += "?" + param; // 검색을 했으면 이렇게 보내고!
		}
		String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);

		// 글보기 주소 만들기!
		String articleUrl = cp + "/article.action?pageNum=" + currentPage;
		if (!param.equals("")) {
			articleUrl += "&" + param;
		}

		// 포워딩할 데이터<지난시간에 메소드로 만들어둠>
		request.setAttribute("lists", lists);
		request.setAttribute("pageIndexList", pageIndexList);
		request.setAttribute("articleUrl", articleUrl);
		request.setAttribute("dataCount", dataCount);

		return "bbs/list";

	
	}
	/*
	@RequestMapping(value="/article.action", method = {RequestMethod.GET,RequestMethod.POST})
	public String article(HttpServletRequest request) throws Exception{
	*/
	
	//아티클
	/*
	@RequestMapping(value = "/article.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String article(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	 */

	@RequestMapping(value = "/article.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView article(HttpServletRequest request,
			HttpServletResponse response) throws Exception{

		String cp = request.getContextPath();
		String url;

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");

		if(searchValue!=null) {
			searchValue = URLDecoder.decode(searchValue, "UTF-8");

		}

		dao.updateHitCount(num);

		//전체데이터 읽어오기
		BoardDTO dto = dao.getReadData(num);

		if(dto==null) {
			url = cp + "/list.action";
			response.sendRedirect(url);

		}

		int lineSu = dto.getContent().split("\n").length;

		dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));

		String param = "pageNum=" + pageNum;
		if(searchValue!=null&&!searchValue.equals("")) {

			param += "&searchKey=" + searchKey;
			param += "&searchValue=" +
					URLEncoder.encode(searchValue, "UTF-8");

		}

		/*
		request.setAttribute("dto", dto);
		request.setAttribute("params", param);
		request.setAttribute("lineSu", lineSu);
		request.setAttribute("pageNum", pageNum);

		return "bbs/article";
		 */

		ModelAndView mav = new ModelAndView();

		mav.addObject("dto", dto);
		mav.addObject("params", param);
		mav.addObject("lineSu", lineSu);
		mav.addObject("pageNum", pageNum);

		mav.setViewName("bbs/article");

		return mav;



	}

	//수정
	@RequestMapping(value = "/updated.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String updated(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	 
		String cp = request.getContextPath();
		String url;

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		BoardDTO dto=  dao.getReadData(num);
		
		if(searchValue!=null) {
			searchValue = 
					URLDecoder.decode(searchValue, "UTF-8");
		}

		if(dto==null) {
			url = cp + "/list.action";
			response.sendRedirect(url);
		}

		String param = "pageNum=" + pageNum;

		if(searchValue!=null&&!searchValue.equals("")) {
			param+= "&searchKey=" + searchKey;
			param+= "&searchValue=" +
					URLEncoder.encode(searchValue, "UTF-8");

		}
		
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("params", param);
		request.setAttribute("searchKey", searchKey);
		request.setAttribute("searchValue", searchValue);

		return "bbs/updated";
		
	}

	@RequestMapping(value = "/updated_ok.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String updated_ok(HttpServletRequest request,
			HttpServletResponse response,BoardDTO dto) throws Exception{

		String cp = request.getContextPath();
		String url;

		String pageNum = request.getParameter("pageNum");

		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");

		dto = new BoardDTO();

		dao.updateData(dto);

		String param = "pageNum=" + pageNum;

		if(searchValue!=null&&!searchValue.equals("")) {

			param += "&searchKey=" + searchKey;
			param += "&searchValue=" + 
					URLEncoder.encode(searchValue, "UTF-8");

		}

		return "redirect:/list.action?param=" + param;

	}
	
	@RequestMapping(value = "/deleted_ok.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String deleted_ok(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");

		dao.deleteData(num);

		String param = "pageNum=" + pageNum;

		if(searchValue!=null&&!searchValue.equals("")) {

			param += "&searchKey=" + searchKey;
			param += "&searchValue=" + 
					URLEncoder.encode(searchValue, "UTF-8");

		}

		return "redirect:/list.action?pageNum=" + pageNum;
	}

	
}
