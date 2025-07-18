package org.koreait.member.social.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.koreait.global.annotations.ApplyCommonController;
import org.koreait.member.social.constants.SocialType;
import org.koreait.member.social.sevices.KakaoLoginService;
import org.koreait.member.social.sevices.NaverLoginService;
import org.koreait.member.social.sevices.SocialLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ApplyCommonController
@RequiredArgsConstructor // 의존성 주입
@RequestMapping("/member/social")
public class SocialController {
    private final HttpSession session;
    private final KakaoLoginService kakaoLoginService;
    private final NaverLoginService naverLoginService;

    @GetMapping("/callback/{channel}/")
    public String callback(@PathVariable("channel")String type, @RequestParam("code") String code , @RequestParam(name = "state", required = false) String rediectUrl){
        SocialType socialType = SocialType.valueOf(type.toUpperCase()); // eum 상수 떼문에 사용 해야 되다

        SocialLoginService  service = socialType == SocialType.NAVER ? naverLoginService : kakaoLoginService;

        // 토큰 발급

        String token = service.getToken(code);

        // 로그인 처리

        if(service.login(token)){
            // 로그인 성공시 리다이렉트 또는 메인페이지로 이동
            return " rediect:" + (StringUtils.hasText(rediectUrl) ? rediectUrl :"/");
        }
        // 로그인 실패시에 아직 소셜 회원 으로 가입된 것이 아니므로 가입 화면으로이동
        session.setAttribute("socialType", "socialType");
        session.setAttribute("SocialToken",token);

        return "redirces/member/ join";

    }







}
