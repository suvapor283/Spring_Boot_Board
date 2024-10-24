package com.mysite.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException {  // RuntimeException 클래스를 상속하는 것은 사용자 정의 예외 클래스를 정의하는 방법중 하나

    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
