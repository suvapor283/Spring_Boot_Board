package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor  // final이 붙은 속성을 포함하는 생성자를 자동으로 생성
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model) {  // Model 객체는 자바 클래스와 템플릿간의 연결고리 역할
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);  // Model 객체에 값을 담아 두면 템플릿에서 사용 가능

        return "question_list";
    }
}