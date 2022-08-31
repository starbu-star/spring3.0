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
	
	//�Է°��� �޼ҵ� �����!
	//num�� �ִ밪 ���ϱ�!
	
	 public int getMaxNum() {
		 int maxNum =0;
		 
		maxNum =sessionTemplate.selectOne("com.boardMapper.maxNum");
		return maxNum; 
	 }
	 
	 
	 //�Է�
	 public void insertData(BoardDTO dto) {
		 sessionTemplate.insert("com.boardMapper.insertData",dto);
		 	 }
	 
	 //��ü������ ��������
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
	 //��ü�������� ����(������ ���� )

	public int getDataCount(String searchKey,String searchValue) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		int dataCount = 0;

		 params.put("searchValue", searchValue);
		 params.put("searchKey", searchKey);
		 
		 dataCount = sessionTemplate.selectOne("com.boardMapper.getDataCount",params);
		 
		return dataCount;
	}
	//num���� �Ѱ��� ������ ��������
	public BoardDTO getReadData(int num) {
		BoardDTO dto = 
				sessionTemplate.selectOne("com.boardMapper.getReadData",num);
		
		return dto;
	}
	//��ȸ�� ���� �޼ҵ�
	public void updateHitCount(int num) {
		sessionTemplate.update("com.boardMapper.updateHitCount",num);
		
		
	}
	
	//����
	public void updateData(BoardDTO dto) {
		
		sessionTemplate.update("com.boardMapper.updateData",dto);
		
	}
	//����
	public void deleteData(int num) {
		sessionTemplate.delete("com.boardMapper.deleteData",num);

	}
}


	
		
	