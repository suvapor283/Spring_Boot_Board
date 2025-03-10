package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.answer.AnswerService;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerREpository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;

    @Test
    void testJpa() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);
    }

    @Test
    void testJpa2() {
        List<Question> all = this.questionRepository.findAll();
        Question q = all.get(0);
    }

    @Test
    void testJpa3() {
        Optional<Question> oq = this.questionRepository.findById(1);
        if (oq.isPresent()) {
            Question q = oq.get();
        }
    }

    @Test
    void testJpa4() {
        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
    }

    @Test
    void testJpa5() {
        Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
    }

    @Test
    void testJpa6() {
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
        Question q = qList.get(0);
    }

    @Test
    void testJpa7() {
        Optional<Question> oq = this.questionRepository.findById(1);
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }

    @Test
    void testJpa8() {
        Optional<Question> oq = this.questionRepository.findById(1);
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.delete(q);
    }

    @Test
    void testJpa9() {
        Optional<Question> oq = this.questionRepository.findById(2);
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        this.answerREpository.save(a);
    }

    @Test
    void testJpa10() {
        Optional<Answer> oa = this.answerREpository.findById(1);
        Answer a = oa.get();
    }

    @Transactional
    @Test
    void testJpa11() {
        Optional<Question> oq = this.questionRepository.findById(2);
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();
    }

    @Test
    void testJpa12() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content, null);
        }
    }
}