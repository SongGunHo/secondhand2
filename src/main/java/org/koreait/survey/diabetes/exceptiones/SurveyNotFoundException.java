package org.koreait.survey.diabetes.exceptiones;

import org.koreait.global.exceptions.script.AlertBackException;
import org.springframework.http.HttpStatus;

public class SurveyNotFoundException extends AlertBackException {

    public SurveyNotFoundException(){
        super("NotFound.survey", HttpStatus.NOT_FOUND);
    }




}
