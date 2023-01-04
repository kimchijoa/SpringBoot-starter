package com.kkh.spingboot.config.auth;

import com.kkh.spingboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  //SpringSecurity 옵션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable().headers().frameOptions().disable() // h2-console 활성화를 위해 사용
            .and()
            .authorizeRequests() // URL별 권한관리 옵션 설정하는 옵션 시작
            .antMatchers("/","/css/**","/images/**", "/js/**","/h2-console/**").permitAll() // 모든 사용자가 접근 가능하게 설정
            .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER 권한을 가진 사람만 가능하도록 설정
            .anyRequest().authenticated() //설정된 URL을 제외한 나머지 URL들은 인증된 사용자들(로그인한 사람들)에게만 허용
            .and()
            .logout().logoutSuccessUrl("/") //로그아웃이 이동할  URL 설정
            .and()
            .oauth2Login() // OAuth2 로그인 기능에 대한 설정 진입 /
                .userInfoEndpoint()// 로그인 이후 사용자 정보 가져올때
                .userService(customOAuth2UserService);// 로그인 성공 이후 후속조치를 진행할 인터페이스 구현제
    }
}
