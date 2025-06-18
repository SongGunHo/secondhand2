package org.koreait.mypage.controllers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.koreait.global.libs.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

    private Utils utils;

    @GetMapping
    public String index(){
        return utils.tpl("mypage/index");
    }









}
