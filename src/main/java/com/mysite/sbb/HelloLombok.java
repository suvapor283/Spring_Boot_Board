package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor  // 해당 속성을 필요로 하는 생성자가 자동으로 생성
@Getter  // final을 적용하면 속성값을 변경할 수 없기 때문에 @Setter는 의미가 없다.
public class HelloLombok {
    private final String hello;  // final은 뒤에 따라오는 자료형과 변수 등을 변경할 수 없게 만드는 키워드
    private final int lombok;  // final이 없다면 생성자에 포함되지 않는다.

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("헬로", 5);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
