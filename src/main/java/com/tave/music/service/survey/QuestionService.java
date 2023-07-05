package com.tave.music.service.survey;

import com.tave.music.domain.survey.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final SurveyRepository surveyRepository;

    //질문 추가
    @Transactional
    public Long addQuestion( Long question_num, String title, String type, int option_count, Answer_option... answer_options){
        //엔티티 조회
        //Survey survey = surveyRepository.findOne(surveyId);

        //질문 생성
        Question question = Question.createQuestion(question_num, title, type, option_count, answer_options);

        //질문 저장
        questionRepository.addQ(question);
        return question.getId();
    }

    //질문 삭제

    //설문조사별 질문 조회
    public List<Question> findQuestionsBySurvey(Long survey_id) {
        return questionRepository.findBySurveyId(survey_id);
    }

    //개별 조회
    public Question findOne(Long question_id) {
        return questionRepository.findOne(question_id);
    }
}
