package com.exe.board.answer;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exe.board.question.Question;
import com.exe.board.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer") //�̷��� �����Ƚ��� �����
@RequiredArgsConstructor
@Controller
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@PostMapping("/create/{id}")//�̷��� �ϸ� �ڿ� �޼ҵ� ���� �Ƚ��൵ ��
	public String createAnswer(Model model,@PathVariable("id") Integer id,
			@Valid AnswerForm answerForm, BindingResult bindingResult) {
		Question question = questionService.getQuestion(id);
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("question", question);
			return "question_detail";
		}
		
		answerService.created(question, answerForm.getContent());
		
		return String.format("redirect:/question/detail/%s", id);
	}

}