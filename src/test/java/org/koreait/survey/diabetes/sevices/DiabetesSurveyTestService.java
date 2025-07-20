//package org.koreait.survey.diabetes.sevices;
//
//import org.junit.jupiter.api.Test;
//import org.koreait.global.constants.Gender;
//import org.koreait.survey.diabetes.constamts.SmokingHistory;
//import org.koreait.survey.diabetes.controllers.RequestDiabetesSurvey;
//import org.koreait.survey.diabetes.entities.DiabetesSurvey;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class DiabetesSurveyTestService {
//    @Autowired
//    DiabetesSurvey survey;
//
//    @Test
//    void test(){
//
//        RequestDiabetesSurvey form = new RequestDiabetesSurvey();
//        form.setGender(Gender.MALE);
//        form.setAge(41);
//        form.setHypertension(false);
//        form.setHeartDisease(false);
//        form.setSmokingHistory(SmokingHistory.EVER);
//        form.setHeight(178.5);
//        form.setWeight(120);
//        form.setHbA1c(8.2);
//        form.setBloodGlucoseLevel(126);
//
//        DiabetesSurvey item = survey(form);
//
//    }
//}
