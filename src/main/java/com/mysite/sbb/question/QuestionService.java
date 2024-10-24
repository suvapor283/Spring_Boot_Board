package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// 서비스 클래스가 필요한 이유
// 1. 복잡한 코드를 모듈화할 수 있다.
// 2. 엔티티 객체를 DTO 객체로 변환할 수 있다.
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {

        return this.questionRepository.findAll();
    }
}