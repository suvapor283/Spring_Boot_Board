package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  // 이 클래스가 컨트롤러의 기능을 수행
public class HelloControler {

    @GetMapping("/hello")  // ()의 URL요청이 발생하면 밑의 메서드가 실행  // 특정 URL경로를 서버의 특정 메서드와 연결
    @ResponseBody  // 메서드의 출력 결과가 문자열 그 자체임
    public String hello() {
        return "Hello Spring Boot Board";
    }
}