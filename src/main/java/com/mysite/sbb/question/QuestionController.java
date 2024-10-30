package com.mysite.sbb.question;

import com.mysite.sbb.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")  // URL 프리픽스
@Controller
@RequiredArgsConstructor  // final이 붙은 속성을 포함하는 생성자를 자동으로 생성
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {  // 매개변수가 다른 경우에 메서드 이름 동일하게 사용 가능 (오버로딩)
        // 이와 같이 매개변수로 바인딩한 객체는 model 객체로 전달하지 않아도 템플릿에서 사용가능하다.
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {  // @valid : 어노테이션 적용시 설정한 검증 기능이 동작함
        if (bindingResult.hasErrors()) {  // BindingResult : @valid 어노테이션으로 검증이 수행된 결과를 의미하는 객체
            return "question_form";
        }

        this.questionService.create(questionForm.getSubject(), questionForm.getContent());

        return "redirect:/question/list";
    }

    @GetMapping("/list")
    public String list(Model model) {  // Model 객체는 자바 클래스와 템플릿간의 연결고리 역할
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);  // Model 객체에 값을 담아 두면 템플릿에서 사용 가능

        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);

        return "question_detail";
    }
}