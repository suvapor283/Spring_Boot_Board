package com.mysite.sbb.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JPA가 제공하는 인터페이스로 CRUD 작업을 처리하는 메서드를 내장하고 있어 관리 작업을 편리하게 처리할수 있음
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findBySubject(String subject);

    // 두개의 열을 조회하기 위해서 AND 연산자 사용
    Question findBySubjectAndContent(String subject, String content);

    // 특정 문자열을 포함한 데이터를 찾기 위해서 LIKE 연산자 사용
    List<Question> findBySubjectLike(String subject);

    @Override
    Page<Question> findAll(Pageable pageable);
}