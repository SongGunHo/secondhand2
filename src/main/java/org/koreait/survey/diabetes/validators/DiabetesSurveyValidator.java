package org.koreait.survey.diabetes.validators;

import org.koreait.survey.diabetes.controllers.RequestDiabetesSurvey;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class DiabetesSurveyValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestDiabetesSurvey.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestDiabetesSurvey form = (RequestDiabetesSurvey) target;
        String mode = form.getMode();
        if(StringUtils.hasText(mode) && mode.equals("step2")){ // step2 검증
            validatorStep2(form, errors);
        } else {// step1 검증
            validatorStep1(form, errors);
        }
    }
    private void validatorStep1(RequestDiabetesSurvey form, Errors errors){
        // 나이 - 5 130
        int age = form.getAge();
        if (age < 5 || age > 130){
            errors.rejectValue("age", "Size");
        }
    }
    private void validatorStep2(RequestDiabetesSurvey form, Errors errors){
        // 키는 50 cm ~350 cm
        // 몸무게 : 10kg ~ 450kg
        // 당화 혈당 색소 수치
        double height = form.getHeight();
        double weight = form.getWeight();
        double hbA1c = form.getHbA1c();
        double blooGulcoseLevel = form.getBloodGlucoseLevel();


        if(height < 50.0 || height > 350.0){
            errors.rejectValue("height", "Size");
        }
        if(weight < 10.0 || weight >450.0){
            errors.rejectValue("weiht", "Size");
        }
        if(hbA1c < 0 || hbA1c > 100.0){
            errors.rejectValue("hbA1c", "Size");
        }
        if(blooGulcoseLevel < 0.0){
            errors.rejectValue("blooGulcoseLevel","Size");
        }
    }
}
