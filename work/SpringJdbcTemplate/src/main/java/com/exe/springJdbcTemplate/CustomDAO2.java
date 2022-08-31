package com.exe.springJdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class CustomDAO2 {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate; //�������� jdbc������ ���� �Ϸ�
		
	}
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	/**�׳� �״�� ���� ������ ����⿡ Ʈ���� ĳġ�� �������*/
	
	public void insertData(CustomDTO dto) {
		
		StringBuilder sql = new StringBuilder();
//		sql.append("insert into custom(id,name,age) values(?,?,?)");
//		/**sql�� �ִ� ���� ���ڷ� �ؼ� ������ �Ͷ�*/
//		jdbcTemplate.update(sql.toString(),dto.getId(),dto.getName(),dto.getAge()); 
		
		//namedJdbcTemplate
		sql.append("insert into custom(id,name,age) values(:id,:name,:age)");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", dto.getId());
		params.addValue("name", dto.getName());
		params.addValue("age", dto.getAge());
		
		namedJdbcTemplate.update(sql.toString(), params);

			
	}
	
	public List<CustomDTO> getList(){
		
			StringBuilder sql = new StringBuilder();
			
			sql.append("select id,name,age from custom");
			
			List<CustomDTO> lists = 
					jdbcTemplate.query(sql.toString(),
							new RowMapper<CustomDTO>() {//�͸��� Ŭ����

								public CustomDTO mapRow(ResultSet rs, int rowNum) 
										throws SQLException {
									
									CustomDTO dto = new CustomDTO();
									
									dto.setId(rs.getInt("id"));
									dto.setName(rs.getString("name"));
									dto.setAge(rs.getInt("age"));
									return dto;
								} 
						
					});
			
			return lists;
				
				
	}
	
	public void updateDate(CustomDTO dto) {
		
		StringBuilder sql = new StringBuilder();
			sql.append("update custom set name=?,age=? where id=?");
			
			jdbcTemplate.update(sql.toString(),dto.getName(),dto.getAge(),dto.getId());
	}
	
	//�ϳ��� ������ �о����
	public CustomDTO getReadData(int id) {
		
			StringBuilder sql = new StringBuilder();
			
			sql.append("select id,name,age from custom where id=?");
			
			CustomDTO dtoOne =
					jdbcTemplate.queryForObject(sql.toString(), 
							new RowMapper<CustomDTO>() {
						

								public CustomDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
									CustomDTO dto = new CustomDTO();
									
									dto.setId(rs.getInt("id"));
									dto.setName(rs.getString("name"));
									dto.setAge(rs.getInt("age"));
									
									return dto;
								}
						
						
					},id); //�̷��� �ؾ� id�� �ϳ��� ������ �о�ü�����
			
				
				return dtoOne;
			}
			
		
	

	public void deleteData(int id) {
		
		StringBuilder sql = new StringBuilder();
			
			sql.append("delete custom where id =?");
			
			jdbcTemplate.update(sql.toString(),id);
			
	}
}