package com.jojoidu.book.springboot.web;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
//테스트를 진행할때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다.
//여기서는 SpringRunner라는 스프링 실행자를 사용합니다.
//즉, 스프링 부트 테스트와 Junit 사이에 연결자 역할을 한다.
@WebMvcTest(controllers = HelloController.class)
//여러 스프링 테스트 어노테이션중, Web에 집중할수있는 어노테이션이다.
//선언할경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
//단 @Service, @Component, @Repository등은 사용할 수 없다.
public class HelloControllerTest extends TestCase {

    @Autowired
    private MockMvc mvc; //web api 테스트용 // 스프링 mvc 테스트의 시작점, 이클래스를 통해 http get, post등에 대한 api 테스트

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //mockMvc를 통해 /hello 주소로 get요청
                .andExpect(status().isOk()) //perform의 결과 검증 ,http header의 status를 검증, 200,404,500상태 검증 여기선 isOk이기때문에 200만 검증
                .andExpect(content().string(hello));// 결과 검증 , 응답 본문의 내용을 검증, controller에서 hello를 리턴하기때문에 이 값이 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name) //값을 설정하는데 String만 허용 // 숫자,날짜 등의 데이터도 등록할때는 문자열로 변경해야한다.
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))  //JSON 응답값을 필드별로 검증할 수 있는 메소드입니다.
                .andExpect(jsonPath("$.amount",is(amount)));//$를 기준으로 필드명을 명시합니다, 여기서는 name과 amount를 겆ㅁ증
    }
}