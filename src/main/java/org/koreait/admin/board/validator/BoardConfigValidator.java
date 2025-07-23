package org.koreait.admin.board.validator;

import lombok.RequiredArgsConstructor;
import org.koreait.admin.board.controllers.RequestBoard;
import org.koreait.board.repository.BoardRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Lazy
@RequiredArgsConstructor
@Component
public class BoardConfigValidator implements Validator {
    private BoardRepository repository;
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestBoard.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        RequestBoard form = (RequestBoard) target;
        String mode  = form.getMode();
        String bid = form.getBid();

        if(mode.equals("register") && repository.existsBid(bid) ){
            errors.rejectValue("bid","Duplicated");
        }
    }
}



