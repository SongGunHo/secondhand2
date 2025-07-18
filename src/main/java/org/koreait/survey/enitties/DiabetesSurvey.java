package org.koreait.survey.enitties;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import org.koreait.global.constants.Gender;
import org.koreait.global.entities.BaseEntity;
import org.koreait.survey.diabetes.constamts.SmokingHistory;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

import java.lang.reflect.Member;

@Data
@Table(schema = "SURVEY_DIABETES")
public class DiabetesSurvey  extends BaseEntity {
    @Id
    @Column("memberSeq")
    private Long memberSeq;
    private Gender gender;
    private int age;

    private boolean hypertension;
    @Column("heartDisease")
    private boolean heartDisease;
    private SmokingHistory smokingHistory;

    private double height;
    private double weight;
    private double bmi;
    @Column("hbA1c")
    private double hbA1c;
    @Column("bloodGlucoseLevel")
    private double bloodGlucoseLevel;

    private boolean diabetes;
    @Transient
    private Member member;
}
