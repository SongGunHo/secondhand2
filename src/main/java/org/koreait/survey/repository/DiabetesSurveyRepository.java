package org.koreait.survey.repository;

import org.koreait.survey.diabetes.entities.DiabetesSurvey;
import org.springframework.data.repository.ListCrudRepository;

public interface DiabetesSurveyRepository extends ListCrudRepository<DiabetesSurvey , Long> {
}
