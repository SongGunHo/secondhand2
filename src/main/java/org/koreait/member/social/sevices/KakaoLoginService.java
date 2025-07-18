package org.koreait.member.social.sevices;

import org.koreait.global.exceptions.script.AlertRedirectException;
import org.springframework.http.*;

private void checkSuccess(HttpStatusCode statusCode){
        if(!statusCode.is2xxSuccessful()){
            throw new AlertRedirectException(utils.getMessage("UnAuthorized.social"),"member/login",HttpStatus.UNAUTHORIZED);
        }
    }


}
