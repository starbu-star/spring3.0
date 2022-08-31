package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.jdbc.dto.BoardDTO;

public class BoardDAO {
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate =sessionTemplate;
	}
	
	//입력관련 메소드 만들기!
	//num의 최대값 구하기!
	
	 public int getMaxNum() {
		 int maxNum =0;
		 
		maxNum =sessionTemplate.selectOne("com.boardMapper.maxNum");
		return maxNum; 
	 }
	 
	 
	 //입력
	 public void insertData(BoardDTO dto) {
		 sessionTemplate.insert("com.boardMapper.insertData",dto);
		 	 }
	 
	 //전체데이터 가져오기
	 public List<BoardDTO> getLists(int start, int end,
			 String searchKey,String searchValue){
		
			Map<String, Object> params = new HashMap<String,Object>();
	 
	 params.put("start", start);
	 params.put("end", end);
	 params.put("searchValue", searchValue);
	 params.put("searchKey", searchKey);
	 
	 List<BoardDTO> lists = sessionTemplate.selectList("com.boardMapper.getLists",params);
	 
		return lists;	
		}
	 //전체데이터의 갯수(맨위랑 같아 )

	public int getDataCount(String searchKey,String searchValue) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		int dataCount = 0;

		 params.put("searchValue", searchValue);
		 params.put("searchKey", searchKey);
		 
		 dataCount = sessionTemplate.selectOne("com.boardMapper.getDataCount",params);
		 
		return dataCount;
	}
	//num으로 한개의 데이터 가져오기
	public BoardDTO getReadData(int num) {
		BoardDTO dto = 
				sessionTemplate.selectOne("com.boardMapper.getReadData",num);
		
		return dto;
	}
	//조회수 증가 메소드
	public void updateHitCount(int num) {
		sessionTemplate.update("com.boardMapper.updateHitCount",num);
		
		
	}
	
	//수정
	public void updateData(BoardDTO dto) {
		
		sessionTemplate.update("com.boardMapper.updateData",dto);
		
	}
	//삭제
	public void deleteData(int num) {
		sessionTemplate.delete("com.boardMapper.deleteData",num);

	}
}


	
		
	