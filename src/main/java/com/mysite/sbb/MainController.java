package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/sbb")
    @ResponseBody  // @ResponsBody를 생략시 리턴 된 이름의 템플릿 파일을 찾음
    public String index() {

        return "안녕하세요 SBB에 오신 것을 환영합니다.";
    }

    @GetMapping("/")
    public String root() {

        return "redirect:/question/list";
    }
}