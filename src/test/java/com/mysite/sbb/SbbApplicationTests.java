package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerREpository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest  // 이 클래스가 스프링부트의 테스트 클래스임을 의미
class SbbApplicationTests {

    @Autowired  // 의존성 주입 : 스프링이 객체를 대신 생성해서 주입하는 기법
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerREpository answerREpository;

    @Test
        // 이 메서드가 테스트 메서드임을 의미
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
        Optional<Question> oq = this.questionRepository.findById(1);  // Optional은 null 값을 유연하게 처리하기 위한 클래스
        if (oq.isPresent()) {  // Optional은 isPresent() 메서드로 값이 존재하는지 확인할 수 있음
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

    @Transactional  // 이 메서드가 종료될 때까지 DB 세션이 유지
    @Test
    void testJpa11() {
        Optional<Question> oq = this.questionRepository.findById(2);
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();
    }
}