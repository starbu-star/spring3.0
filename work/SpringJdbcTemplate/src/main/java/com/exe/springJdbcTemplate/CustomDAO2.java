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
		this.jdbcTemplate=jdbcTemplate; //스프링의 jdbc의존성 주입 완료
		
	}
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	/**그냥 그대로 쓰면 문제가 생기기에 트라이 캐치로 묶어야함*/
	
	public void insertData(CustomDTO dto) {
		
		StringBuilder sql = new StringBuilder();
//		sql.append("insert into custom(id,name,age) values(?,?,?)");
//		/**sql에 있는 내용 문자로 해서 가지고 와라*/
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
							new RowMapper<CustomDTO>() {//익명의 클래스

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
	
	//하나의 데이터 읽어오기
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
						
						
					},id); //이렇게 해야 id로 하나의 데이터 읽어올수있음
			
				
				return dtoOne;
			}
			
		
	

	public void deleteData(int id) {
		
		StringBuilder sql = new StringBuilder();
			
			sql.append("delete custom where id =?");
			
			jdbcTemplate.update(sql.toString(),id);
			
	}
}
