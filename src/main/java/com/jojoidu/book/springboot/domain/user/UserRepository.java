package com.jojoidu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    //소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위한 메소드
    Optional<User> findByEmail(String email);
    /*
    * 메서드가 반환할 결과값이 ‘없음’을 명백하게 표현할 필요가 있고,
    * null을 반환하면 에러를 유발할 가능성이 높은 상황에서 메서드의 반환 타입으로 Optional을 사용하자는 것이 Optional을 만든 주된 목적이다.
    * Optional 타입의 변수의 값은 절대 null이어서는 안 되며, 항상 Optional 인스턴스를 가리켜야 한다.*/

}
