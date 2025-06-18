package org.koreait.member.services;

import lombok.RequiredArgsConstructor;
import org.koreait.member.MemberInfo;
import org.koreait.member.repositories.MemberRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Objects;

@Lazy
@Service
@RequiredArgsConstructor
public class MemerInfoService implements UserDetailsService {

    private final MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = repository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(username));

        Authentication authentication = Objects.requireNonNullElse(member.getAuthority(), Authentication.MEMBER);
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(authentication.name()));

        return MemberInfo.builder().email(member.getEmail()).password(member.getPassword).authorities(authorities).build();
    }
}
