package org.koreait.survey.diabetes.sevices;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.koreait.member.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootTest
public class DiabetesSurveyPredictServiceTest {
    @Autowired
    private DiabetesSurveyPredictServiceTest serviceTest;

    private ObjectMapper om;


    @Test
    void test(){}
        String json ="[[Female, 65.0, 0, 1, 4, 42.88, 5.0, 130], [Male, 47.0, 0, 0, 0, 27.32, 5.8, 145], [Female, 56.0, 1, 0, 1, 21.31, 4.5, 145], [Male, 26.0, 0, 0, 0, 23.38, 6.5, 90], [Female, 54.0, 0, 0, 1, 20.45, 6.1, 140]]";

        List<List<Member>> items= om.readValue(json, new TypeReference<>(){});
        List<Integer> result = serviceTest.process(items);

    @Test
    void test2(){
        List<Number> item = List.of(1,46,0,0.0,0.0,3,29.6,5.8,130);

        boolean result = serviceTest.isD
    }

}
