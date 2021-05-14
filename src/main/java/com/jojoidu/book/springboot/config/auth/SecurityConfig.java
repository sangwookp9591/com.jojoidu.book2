package com.jojoidu.book.springboot.config.auth;

import com.jojoidu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정 확성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
       .csrf().disable()
       .headers().frameOptions().disable()// h2-console 화면을 사용하기 위해 해당 옵션들을 disable한다.
               .and()
                   .authorizeRequests() // url별 권한 관리를 설정하는 옵션의 시작점
                   .antMatchers("/","css/**","/images/**","js/**","/h2-console/**")//권한 관리 대상 지정 URL,HTTP 메소드별로 관리가 가능하다.
                   .permitAll()
                   .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //USER권한을 가진사람만 사용가능함.
                   .anyRequest().authenticated() //설정된 값들 이외 나머지 URL 여기서는 authoenticated()을 추가하여 나머지 URL들은 모두 인증된 사용자들에게만 허용하게한다.
               //인증된 사용자 즉 , 로그인한 사용자들만 가능.
               .and()
                    .logout()
                        .logoutSuccessUrl("/") //로그아웃 기능에 대한 여러 설정의 진입점. 로그아웃 성공시 /주소로 이동.
               .and()
                    .oauth2Login() // oauth2로그인 기능에 대한 여러 설정의 진입점.
                        .userInfoEndpoint() //로그인 성공 이후 사용자 정보를 가져올떄 설정파일을 담당
                            .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행할 UserService인터페이스의 구현체 등록
                                //리소스 서버에서 사용자정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
    }
}
