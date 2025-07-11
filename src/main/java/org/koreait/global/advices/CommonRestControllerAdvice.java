package org.koreait.global.advices;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestControllerAdvice.class)
public class CommonRestControllerAdvice {
    @ExceptionHandler(Exception.class)
    public String errorHeader(){
        return "에러 발생";
    }

}
