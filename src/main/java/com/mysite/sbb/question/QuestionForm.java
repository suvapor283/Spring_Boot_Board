package com.mysite.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {

    @NotEmpty(message = "제목은 필수항목입니다.")  // null 또는 빈 문자열을 허용하지 않음  // message : 검증에 실패할 경우 화면에 띄울 오류 메세지
    @Size(max = 200)  // 200바이트 보다 큰 값이 입력되면 오류 발생
    private String subject;

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}