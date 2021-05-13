package com.jojoidu.book.springboot.web;

import com.jojoidu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다
//예전에는 @ResponseBody를 각 메소드마다 선언했던것을 한번에 사용할 수 있게 한다.
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){ //@RequestParam 외부에서 api로 넘긴 파라미터를 가져오는 어노테이션


        return new HelloResponseDto(name,amount);
    }

}
