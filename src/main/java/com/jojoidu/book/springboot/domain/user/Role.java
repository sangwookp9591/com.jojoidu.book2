package com.jojoidu.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST","손님"),
    USER("ROLE_USER","일반 사용자");
    //Spring security는 권한 코드에 항상 ROLE이 앞에 있어야하만 한다. 그래서 코드별 키 값을 위처럼 명시한다.

    private final String key;
    private final String title;
}
