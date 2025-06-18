package org.koreait.survey.diabetes.controllers;

import jakarta.validation.Valid;
import org.flywaydb.core.api.callback.Error;
import org.koreait.global.constants.Gender;
import org.koreait.global.libs.Utils;
import org.koreait.survey.diabetes.constamts.SmokingHistory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.imageio.stream.ImageOutputStreamImpl;
import java.util.List;

@Controller
@RequestMapping("/survey/diabetes")
@SessionAttributes("requestDiabetesSurvey")
public class DiabetesSurveyController {
    private  Utils utils;

    @ModelAttribute("addCss")
    public List<String> addCss(){
        return List.of("survey/diabetes/style");
    }
    @ModelAttribute("gender")
    public Gender[] gender(){
        return Gender.values();
    }
    @ModelAttribute("smokingHistory")
    public SmokingHistory[] smokingHistory(){
        return SmokingHistory.values();
    }



    @ModelAttribute("requestDiabetesSurvey")
    public RequestDiabetesSurvey requestDiabetesSurvey(){

        return new RequestDiabetesSurvey();
    }
    @GetMapping("/step1")
    public String step1(@ModelAttribute RequestDiabetesSurvey form, Model model){
        commonProcess("step", model);
        return utils.tpl("survey/diabetes/step1");
    }
    @GetMapping("/step2")
    public String step2 (RequestDiabetesSurvey form , Error errors, Model model){
        commonProcess("step",model);
        if (errors.hasErrors()){
            return utils.tpl("survey/diabetes/step1");
        }
         return utils.tpl("survey/diabetes/step2");
    }

    @PostMapping("/process")
    public String process(@Valid RequestDiabetesSurvey form , Errors errors ,Model model){
        commonProcess("step", model);

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
    public String result(@PathVariable("seq") Long seq, Model model){
        commonProcess("result", model);
        return utils.tpl("survey/diabetes/result");

    }

    /**
     * controller 공통 처리
     * @param mode
     * @param model
     */

    private void commonProcess(String mode , Model model){
        mode = StringUtils.hasText(mode) ? mode : "step";
        String pageTittle ="";
        if(mode.equals("step")){
            pageTittle =  utils.getMessage("당뇨_고위험군_테스트");

        }else if(mode.equals("result")){
            pageTittle = utils.getMessage("당뇨_고위험군_결과");

        }
        model.addAttribute("pageTitle", pageTittle);
    }




}
