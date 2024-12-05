package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity  // @Entity 어노테이션을 적용해야 스프링 부트가 이 클래스를 엔터티로 인식
public class Question {

    @Id  // 이 속성을 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue : 속성에 값을 입력하지 않아도 자동으로 1씩 증가  // strategy = GenerationType.IDENTITY : 고유한 번호를 생성하는 방법으로 해당 속성만 별도로 번호가 차례대로 늘어나도록 지정
    private Integer id;

    @Column(length = 200)  // @Column : 열의 세부 설정 지정  // length : 열의 길이 설정
    private String subject;

    @Column(columnDefinition = "TEXT")
    // columnDefinition : 유형이나 성격을 정의  // "TEXT" : 텍스트를 열 테이터로 넣을 수 있고 글자수를 제한할 수 없는 경우 사용
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    // @OneToMany : 1:N 관계  // mappedBy : 참조 엔터티의 속성명을 정의  // CascadeType.REMOVE : 부모 튜플이 삭제될 경우 관련된 자식 튜플도 모두 삭제
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;
}