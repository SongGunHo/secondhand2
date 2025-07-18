
package org.koreait.survey.diabetes.sevices;

import lombok.RequiredArgsConstructor;
import org.koreait.global.configs.ModelMapper;
import org.koreait.member.entities.Member;
import org.koreait.member.libs.MemberUtil;
import org.koreait.survey.diabetes.controllers.RequestDiabetesSurvey;
import org.koreait.survey.diabetes.services.DiabetesSurveyPredictService;
import org.koreait.survey.enitties.DiabetesSurvey;
import org.koreait.survey.repostoryes.DiabetesSurveyRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@RequiredArgsConstructor
public class DiabetesSurveyService {
    private DiabetesSurveyRepository repository;
    private MemberUtil util;
    private DiabetesSurveyPredictPredictService predictPredictService;
    private ModelMapper mapper;
    private final DiabetesSurveyPredictService predictService;
    public void process(RequestDiabetesSurvey form) {

/**
 *  1.  설문 딥변으로 단요 고위험군 예측 겱과 가지고 오기
 * 2. 로그인 한 회원 정보 가지고 오기
 * 3. dB 에 저장 처리
 *
 */
        boolean diabetes = predictPredictService.isDiabetes(form);
        Member member = util.getMember();
        double bmi = predictService.getBmi(form.getHeight(), form.getWeight());

        DiabetesSurvey item = mapper.map(form, DiabetesSurvey.class);

        item.setDiabetes(diabetes);
        item.setBmi(bmi);
        if (util.isLogin()) {
          item.setMember(member);
        }

        repository.savAndFlush(item);

        return repository.findById(item.getSeq()).orElse(null);
    }}
