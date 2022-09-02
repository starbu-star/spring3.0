package com.exe.board.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		//�������� ���� ��� ��û�� ���
		http
		.authorizeRequests().antMatchers("/**").permitAll()
		.and()
		.csrf().ignoringAntMatchers("/h2-console/**")
		//.disable().headers().frameOptions().disable() //�Ʒ� and!sameorigin ������ �̷��� ��� �ȴ� .
		.and()
		.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(
				XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))//���İ����� ������ �����
		;
		
		return http.build();
	}
	
}
/*
 * CSRF(Cross Site Request Forgery)
 * ������Ʈ�� ����� ������ �����ϱ� ���� ����ϴ� ���
 * ���Ǹ� ��ť�Ƽ�� CSRF ��ū���� ������ ���� �����ϰ�
 * �������������� �� ���۽ÿ� �ش� ��ū�� �Բ� �����ؼ� 
 * ���� �� ���������� �ۼ��� �����Ͱ� ���޵Ǵ����� �����ϴ� ���
 */ 