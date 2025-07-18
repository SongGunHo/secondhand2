package org.koreait.member.social.test;

import org.junit.jupiter.api.Test;
import org.koreait.member.social.enitiites.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@SpringBootTest

public class AccessTokenTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void test1(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();


        body.add("grant_type", "authorzation_code");
        body.add("client_id","8ac08bc6507828373e4c1f13ec6aed72");
        body.add("redirect_url", "https://localhost:3000/memer/social/callbcak/kakao");
        body.add("code","9b6dab9d307653059c0fe7ff198845fd&redirect_uri=http://localhost:3000/member/social/callback/kakao");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);



        String url = "	https://kauth.kakao.com/oauth/authorize";

        String requestUrl = "https://kauth.kakao.com/oauth/token";

        ResponseEntity<AuthToken> response = restTemplate.exchange(URI.create(requestUrl), HttpMethod.POST, request, AuthToken.class);
        HttpStatusCode statusCode = response.getStatusCode();
        System.out.println("stausCode" +statusCode);
        // acess Token 회원 정보
        requestUrl ="https://kapi.kakao.com/v2/user/me";

        headers = new HttpHeaders();
         requestUrl = "https://kauth.kakao.com/oauth/token";
        ResponseEntity<Map> res = restTemplate.exchange(URI.create(requestUrl), HttpMethod.POST, request, Map.class);
        request = new HttpEntity<>(headers);
        
        Map resBody = res.getBody();
        long id = (Long) resBody.get("id");
        System.out.println(id);



    }

}
