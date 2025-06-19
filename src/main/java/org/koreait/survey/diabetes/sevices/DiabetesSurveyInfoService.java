package org.koreait.survey.diabetes.sevices;

import lombok.RequiredArgsConstructor;
import org.koreait.global.constants.Gender;
import org.koreait.global.search.CommonSeacrch;
import org.koreait.global.search.ListData;
import org.koreait.member.libs.MemberUtil;
import org.koreait.survey.diabetes.constamts.SmokingHistory;
import org.koreait.survey.enitties.DiabetesSurvey;
import org.koreait.survey.exceptiones.SurveyNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.sql.ResultSet;
import java.sql.SQLException;

@Lazy
@Service
@RequiredArgsConstructor
public class DiabetesSurveyInfoService {
    private final JdbcTemplate jdbcTemplate;
    private final MemberUtil util;
    /**
     *
     * 설문지 한개 조회
     *
     * @param seq
     * @return
     */
    public DiabetesSurvey get(Long seq){
        try{
            String sel  = "SELECT s. * , m.email, m.name, m.mobile FROM SURVEY_DIABETES s"+ "LEFT JOIN MEMBER m ON s.memberSeq  m.seq WHERE seq =?";
            return jdbcTemplate.queryForObject(seq, this:: mapper, sel);

        }catch (DataAccessException e){
            throw  new SurveyNotFoundException();
        }
    }

    /**
     *  목록 조회
     *  회원 전용
     * @param seacrch
     * @return
     */

    public ListData<DiabetesSurvey> getList(CommonSeacrch seacrch){
        if (!util.isLogin()){
            return new ListData<>();
        }
        int page = Math.max(seacrch.getPage(),1);
        int limit = seacrch.getLimit();
        limit = limit < 1?10 :limit;
        int offset=(page -1) * limit ; // 레코드 시작
        Member member = util.getMember();// 현재 로그인 한 정보
        String sel  = "SELECT s. * , m.email, m.name, m.mobile FROM SURVEY_DIABETES s"+ "LEFT JOIN MEMBER m ON s.memberSeq  m.seq WHERE memberSeq =?"+ "ORDER BY createdAt DESC LIMIT ? , ?";
        return null;
    }


    private DiabetesSurvey mapper(ResultSet rs , int i) throws SQLException {
        DiabetesSurvey item = new DiabetesSurvey();
        item.setSeq(rs.getLong("seq"));
        item.setMemberSeq(rs.getLong("memberSeq"));
        item.setGender(Gender.valueOf(rs.getString("gender")));
        item.setAge(rs.getInt("age"));
        item.setDiabetes(rs.getBoolean("diabetes"));
        item.setBmi(rs.getDouble("bmi"));
        item.setHeight(rs.getDouble("height"));
        item.setWeight(rs.getDouble("weight"));
        item.setHypertension(rs.getBoolean("hypertension"));
        item.setHeartDisease(rs.getBoolean("heartDisease"));
        item.setHbA1c(rs.getDouble("hbA1c"));
        item.setBloodGlucoseLevel(rs.getDouble("bloodGlucoseLevel"));
        item.setSmokingHistory(SmokingHistory.valueOf(rs.getString("smokingHistory")));


        Member member = new Member();
        member.setSeq(rs.getLong("memberSeq"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setMobile(rs.getString("mobile"));

        item.setMember(member);

        return item;
    }

}
