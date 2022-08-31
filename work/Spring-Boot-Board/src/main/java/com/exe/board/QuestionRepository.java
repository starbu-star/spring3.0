package com.exe.board;

import org.springframework.data.jpa.repository.JpaRepository;

//������ ó���� ���ؼ��� ���� �����ͺ��̽��� �����ϴ�
//JPA�� Repository�� �ʿ��ϴ�.

//��ƼƼ�� ���� ������ �����ͺ��̽� ���̺��� �����ϴ� �޼ҵ带 
//����ϱ� ���� �������̽��̴�.(findAll,save)
//CRUD(create,Read,Update,Delete)�۾��� �ϴ� ����
public interface QuestionRepository extends JpaRepository<Question, Integer>{
//������� �̷��Ը� ������ָ� questionRepositoryȣ���Ͽ� �����
	
	//findBy+��ƼƼ��
	Question findBySubject(String subject);
	
	
}