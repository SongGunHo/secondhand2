package org.koreait.member.services;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.koreait.member.controllers.RequestJoin;
import org.koreait.member.entities.Member;
import org.koreait.member.repositories.MemberRepository;
import org.koreait.member.social.constants.SocialType;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Lazy
@Service
@RequiredArgsConstructor
public class JoinService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder encoder;
    private final MemberRepository repository;
    private final HttpSession session;

    public void process(RequestJoin form) {
        /**
         * 1. 비밀번호를 BCrypt 해시화
         * 2. 휴대전화번호 통일화, 010-1000-1000, 01010001000, 010.1000.1000
         *      - 숫자만 남기고 다 제거
         * 3. DB에 영구 저장
         */

        String hash = encoder.encode(form.getPassword());
        String mobile = form.getMobile();
        if (StringUtils.hasText(mobile)) {
            mobile = mobile.replaceAll("\\D", "");
        }

        String password  = form.getPassword();
        Member member = StringUtils.hasText(password)? encoder.encode(form.getPassword()): null;
        member.setPassword(hash);
        member.setMobile(mobile);
        member.setCredentialChangedAt(LocalDateTime.now());
        member.setScoialType(Object.requireNonNullelse(form.getSocialType(), SocialType.NONE));
        member.setSocialToken(form.getSocialToken());

        repository.saveAndFlush(member);
        //  소셜 로그인 관련 세션값 삭제
        session.removeAttribute("socialType");
        session.removeAttribute("socialToken");
    }
}
