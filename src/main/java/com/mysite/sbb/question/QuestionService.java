package com.mysite.sbb.question;

import com.mysite.sbb.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 서비스 클래스가 필요한 이유
// 1. 복잡한 코드를 모듈화할 수 있다.
// 2. 엔티티 객체를 DTO 객체로 변환할 수 있다.
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public void create(String subject, String content) {
        Question question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());

        this.questionRepository.save(question);
    }

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

    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));

        return this.questionRepository.findAll(pageable);
    }
}