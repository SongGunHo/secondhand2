package org.koreait.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
public class TestController2 {

    @GetMapping
    public void  test1()

    {
        boolean result = false;

        if(!result){
            return "확인";
        }

    }


}
