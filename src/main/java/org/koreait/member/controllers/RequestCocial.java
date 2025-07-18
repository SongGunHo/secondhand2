package org.koreait.member.controllers;

import lombok.Data;

@Data
public class RequestCocial {

    private SocialType  socialType;

    private String socialToken;
}
