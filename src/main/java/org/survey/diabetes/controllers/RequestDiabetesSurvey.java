package org.survey.diabetes.controllers;

import lombok.Data;
import org.koreait.global.constants.Gender;
import org.springframework.stereotype.Controller;

@Data
public class RequestDiabetesSurvey {

    private Gender gender;
    private int age;
    private boolean hypertension;// 고혈압 여부
    private boolean heartDisease; // 심장질환










}
