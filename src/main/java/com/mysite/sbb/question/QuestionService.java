package com.mysite.sbb.question;

import com.mysite.sbb.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Question getQuestion(Integer id) {
        Optional<Question> questionOptional = this.questionRepository.findById(id);

        if (questionOptional.isPresent()) {
            return questionOptional.get();
        }

        throw new DataNotFoundException("question not found");
    }
}