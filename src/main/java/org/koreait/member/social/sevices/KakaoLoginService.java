package org.koreait.member.social.sevices;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@RequiredArgsConstructor
public class KakaoLoginService implements  SocialLoginService {


    @Value("${kakao.api}")
    private String apikey;

    @Override
    public String getToken(String code) {
        return "";
    }

    @Override
    public boolean login(String token) {
        return false;
    }

    @Override
    public boolean exists(String token) {
        return true;
    }

    @Override
    public String getLoginUrl() {
        String rediectUrl= "";
        return String.format("https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=9b6dab9d307653059c0fe7ff198845fd&redirect_uri=http://localhost:3000/member/social/callback/kakao=mypage");
    }

    @Override
    public String getRediectUrl() {
        return "";
    }
}
