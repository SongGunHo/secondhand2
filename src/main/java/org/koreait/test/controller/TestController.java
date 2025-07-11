package org.koreait.test.controller;

import org.koreait.global.exceptions.BadRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String test(){
        boolean result = false;
        if(!result){
            throw new BadRequestException("텍스트 예외 발생");
        }
        return "test";
    }
}
