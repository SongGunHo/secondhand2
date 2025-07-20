package org.koreait.survey.repository;

import org.koreait.survey.diabetes.entities.DiabetesSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.repository.ListCrudRepository;

public interface DiabetesSurveyRepository extends JpaRepository<DiabetesSurvey, Long> {
}
