package com.jojoidu.book.springboot.web.dto;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class HelloResponseDtoTest extends TestCase {

    @Test
    public void 롬복_기능_테스트() {

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //assertj라는 테스트 검증 라이브러리의 검증 메소드입니다.
        //검증하고 싶은 대상을 메소드 인자로 받습니다/
        //메소드 체이닝이 지원되어 isEqualsTo와 같이 메소드를 이어서 사용할 수 있습니다.

    }

}