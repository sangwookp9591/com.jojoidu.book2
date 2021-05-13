package com.jojoidu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication //스프링부트 자동설정, 스프링 Bean 읽기 생성
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //SpringApplication.run으로 was를 외부에서 실행하지 않고 내부에서 was를 실행한다.
        //이렇게되면 tomcat을 설치할 필요가 없고, 스프링 부트로 만들어진 jar 파일로 실행하면 된다.

    }

}

