package com.kkh.spingboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class) //SpringBoot Test와 JUnit 사이의 연결자 역할함 (SpringRunner라는 실행자 사용)
@SpringBootTest
@WebMvcTest(controllers = HelloControllerTest.class) //테스트 어노테이션 중 Web에만 집중 가능함 @Controller, @ControllerAdvice 사용 가능
public class HelloControllerTest {

    @Autowired  //bean 주입
    private MockMvc mvc;  // Web API 테스트용

    @Test
    public void  re_hello() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")).andExpect(status().isOk()). //status 상태 검증
                andExpect(content().string(hello)); //결과 검증
    }
}
