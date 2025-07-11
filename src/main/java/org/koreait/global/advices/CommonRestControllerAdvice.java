package org.koreait.global.advices;


import org.koreait.global.exceptions.CommonException;
import org.koreait.global.libs.Utils;
import org.koreait.global.rests.JsonError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;


@RestControllerAdvice(annotations = RestControllerAdvice.class)
public class CommonRestControllerAdvice {
    private  Utils utils;
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JsonError> errorHeader(Exception e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;// 기본 에러 코드는 500
        Object message = e.getMessage();
        if(e instanceof CommonException commonException){
            status = commonException.getStatus();
            Map<String, List<String>> errorMessage = commonException.getError();
            if(errorMessage != null){
                message = errorMessage;
            }else {
                if (commonException.isErrorCode()){
                    message = utils.getMessage((String)message);
                }
            }
        }
         e.printStackTrace();

        return ResponseEntity.status(status).body(new JsonError(status, message));
    }

}
