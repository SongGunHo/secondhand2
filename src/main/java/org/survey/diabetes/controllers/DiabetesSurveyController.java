package org.survey.diabetes.controllers;

import jakarta.validation.Valid;
import org.flywaydb.core.api.callback.Error;
import org.koreait.global.libs.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/survey/diabetes")
@SessionAttributes("requestDiabetesSurvey")
public class DiabetesSurveyController {
    private final Utils utils;
    @ModelAttribute("requestDiabetesSurvey")
    public RequestDiabetesSurvey requestDiabetesSurvey(){

        return new RequestDiabetesSurvey();
    }
    @GetMapping("/step1")
    public String step1(@ModelAttribute RequestDiabetesSurvey form){
        return utils.tpl("survey/diabetes/step1");
    }
    @GetMapping("/step2")
    public String step2 (RequestDiabetesSurvey form , Error errors){
        if (errors.hasErrors()){
            return utils.tpl("survey/diabetes/step1");
        }
         return utils.tpl("survey/diabetes/step2");
    }

    @PostMapping("/process")
    public String process(@Valid RequestDiabetesSurvey form , Errors errors){

        if(errors.hasErrors()){
            return utils.tpl("survey/diabetes/step2");
        }
        return "redirect:/survey/diabetes/result/설문 번호";
    }

    /**
     * 설문 결과 보기
     *
     * @return
     */

    @GetMapping("/result/{seq}")
    public String result(@PathVariable("seq") Long seq){
        return utils.tpl("survey/diabetes/result");

    }




}
