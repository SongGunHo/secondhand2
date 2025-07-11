package org.koreait.test.controller;

import jakarta.validation.Valid;
import org.koreait.global.annotations.ApplyCommonController;
import org.koreait.global.exceptions.BadRequestException;
import org.koreait.global.libs.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("test")
@ApplyCommonController
public class TestController {
    private Utils utils;

    @GetMapping
    public String test(){
        boolean result = false;
        if(!result){
            throw new BadRequestException("텍스트 예외 발생");
        }
        return "test";
    }
    @PostMapping
    public  void  test2(@RequestBody @Valid RequestTest from , Errors errors){
        if(errors.hasErrors()){
            throw new BadRequestException(utils.getErrorMessage(errors));
        }
    }
}
