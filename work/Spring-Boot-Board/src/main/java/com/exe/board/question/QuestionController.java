package com.exe.board.question;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exe.board.answer.AnswerForm;

import groovy.lang.Binding;
import lombok.RequiredArgsConstructor;
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	//private final QuestionRepository questionRepository;
	//���� �� ���� ģ�� ��� service �� �ʿ��ϴ�.
	private final QuestionService questionService;
	
	
	@RequestMapping("/list")
	public String list(Model model,@PageableDefault Pageable pageable) {
		
		Page<Question> paging = questionService.getList(pageable);//�̷��� �ϸ� �ٸ������� ��ü ������ �ʿ��ϸ� getlist �� ��� ȣ�����ָ� �ȴ�.
		//List<Question> lists = questionRepository.findAll();
		model.addAttribute("paging",paging);
		
		return "question_list";
	}
	//���ø��� ���� 
	//Thymeleaf/Mustache/Groovy/freemarke/Velocity
	@RequestMapping("/detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id,
			AnswerForm answerForm) {
		Question question = questionService.getQuestion(id);
		
		model.addAttribute("question",question);
		
		return "question_detail";
	}
	@GetMapping("/create")
	public String questionCreate(QuestionForm questioForm) { //�Է�â�� ������ ��������� �˻��ض� 
		return "question_form";
	}
	//�����ϱ� > ����ϱ� Ŭ���ϸ� �����̷�Ʈ �ǰ� �ؾ��Ѵ�.
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) { //���� ������ �ٲ�� �ȵȴ�.
		if(bindingResult.hasErrors()) {
			return "question_form";
		}
	//�Է�
		questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list";

	}
	
}
