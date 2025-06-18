package org.koreait.survey.diabetes.sevices;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.koreait.global.constants.Gender;
import org.koreait.member.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.survey.diabetes.constamts.SmokingHistory;
import org.survey.diabetes.controllers.RequestDiabetesSurvey;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootTest
public class DiabetesSurveyPredictServiceTest {
    @Autowired
    private DiabetesSurveyPredictServiceTest serviceTest;

    private ObjectMapper om;


    @Test
    void test()throws Exception {
        String json = "[[Female, 65.0, 0, 1, 4, 42.88, 5.0, 130], [Male, 47.0, 0, 0, 0, 27.32, 5.8, 145], [Female, 56.0, 1, 0, 1, 21.31, 4.5, 145], [Male, 26.0, 0, 0, 0, 23.38, 6.5, 90], [Female, 54.0, 0, 0, 1, 20.45, 6.1, 140]]";

        List<List<Member>> items = om.readValue(json, new TypeReference<>() {});
        List<Integer> result = serviceTest.process(items);
    }
    @Test
    void test2(){
        //List<Number> item = List.of(1, 46.0, 0.0, 0.0, 3, 29.6, 5.8, 130);
//        List<Number> item = List.of(1, 41, 0, 0, 0,29.6, 8.2, 126);
//        boolean result = serviceTest.isDiabetes(item);
//        System.out.println(result);

        RequestDiabetesSurvey form = new RequestDiabetesSurvey();
        form.setGender(Gender.MALE);
        form.setAge(41);
        form.setHypertension(false);
        form.setHeartDisease(false);
        form.setSmokingHistory(SmokingHistory.EVER);
        form.setHeight(178.5);
        form.setWeight(120);
        form.setHbA1c(8.2);
        form.setBloodGlucoseLevel(126);

        boolean result = serviceTest.isDiabetes(form);
        System.out.println(result);

    }

}
