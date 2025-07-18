package org.koreait.member.social.sevices;

public interface SocialLoginService {
    String getToken(String code);
    boolean login(String token);
    boolean exists(String token);
    String getLoginUrl();
    String getRediectUrl();




}
