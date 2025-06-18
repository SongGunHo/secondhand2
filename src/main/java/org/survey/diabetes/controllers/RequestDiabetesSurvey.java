package org.survey.diabetes.controllers;

import lombok.Data;
import org.koreait.global.constants.Gender;
import org.springframework.stereotype.Controller;
import org.survey.diabetes.constamts.SmokingHistory;

@Data
public class RequestDiabetesSurvey {

    private Gender gender;
    private int age;
    private boolean hypertension;// 고혈압 여부
    private boolean heartDisease; // 심장질환
    private SmokingHistory smokingHistory;
    private double height; // 키
    private double weight; // 몸무게
    private double hbA1c; // 당화혈 색소 수치( 2~3개월 동안 평균 혈당 수치)
    private double bloodGlucoseLevel;// 혈당 색소










}
