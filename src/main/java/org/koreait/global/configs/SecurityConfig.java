package org.koreait.global.configs;

import lombok.RequiredArgsConstructor;
import org.koreait.member.MemberAccessDeniedHandler;
import org.koreait.member.MemberInfo;
import org.koreait.member.services.LoginFailureHandler;
import org.koreait.member.services.LoginSuccessHandler;
import org.koreait.member.services.MemberAuthenitcaionExceptionHandker;
import org.koreait.member.services.MemberInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@RequiredArgsConstructor //  의존성
public class SecurityConfig {
    private  final MemberInfoService memberInfoService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /*인증 설정- 로그인 , 로그아웃  S*/
        http.formLogin(c-> {
           c.loginPage("/member/login").usernameParameter("email").passwordParameter("password").successHandler(new LoginSuccessHandler()).failureHandler(new LoginFailureHandler());
        });
        /*인증 설정 - 로그인 , 로그아웃 E*/

        http.logout(c-> {
            c.logoutUrl("/logout").logoutSuccessUrl("/member/login");
        });
        /* 자동 로그인 */
        http.rememberMe(c-> {
            c.rememberMeParameter("autoLogin").tokenValiditySeconds(60 * 60 * 24 * 7) // 7일간 자동 로그인 유지
                    .userDetailsService(memberInfoService).authenticationSuccessHandler(new LoginSuccessHandler());
        });
        /* 인가 설정 - 자원에 대한 권한 설정 s*/
        /**
         * authenticated() : 인증 받은 사용자만 접근 가능 (회원)
         * anonymous: 인증 받지 안은 사용자만 접근 가능 (비회원)
         * permitall : 모든 사용자 접근 가능
         * hasAuthority: 하나의 권한을 체크
         * hasAnyauthority(권한 1 권한 2 ) 다수 권한
         *  hasRole(롤 이름) 롤 이름으로 권한을 체크
         * hasAnyRole(롤1 롤2) :   다수의 롤으로 권한을 체크
         *  anyRequest().permitall : 비회원 페이지가 기본 일부 페이지 - 회원 전용
         *  anyRequest().autbnticated(): 비회원 전용 페이지 기본 일부 페이지 - 비회원
         * requestMatchers url 경로별로 인가 인증 관련
         */
            http.authorizeHttpRequests(c-> {
               c.requestMatchers("/mypage/**").authenticated().requestMatchers("/member/join","member/login/").anonymous().requestMatchers("/admin/**").hasAnyAuthority("ADMIN").anyRequest().permitAll();
            });
        /* 인가 설정 - 자원에 대한 권한 설정 e*/
            http.exceptionHandling(c -> {
               c.authenticationEntryPoint(new MemberAuthenitcaionExceptionHandker()); // 비로그인 상태에서 인증 인가 실패에 대한 처리
                c.accessDeniedHandler(new MemberAccessDeniedHandler());// 인증 받은 회원이 권한 이 없는 패이지
            });
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
