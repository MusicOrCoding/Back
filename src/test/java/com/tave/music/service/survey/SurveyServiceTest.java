package com.tave.music.service.survey;

import com.tave.music.domain.User.User;
import com.tave.music.domain.survey.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SurveyServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired SurveyService surveyService;
    @Autowired SurveyRepository surveyRepository;
//    @Autowired
//    QuestionRepository questionRepository;
    @Autowired QuestionService questionService;
//    @Autowired
//    Answer_optionRepository answer_optionRepository;
    @Autowired Answer_optionService answer_optionService;

    @Test
    public void 설문조사_등록() throws Exception {
        //given
        User user = new User();
        em.persist(user);

        Answer_option a = Answer_option.createAnswerOption("선택지1");
        Answer_option b = Answer_option.createAnswerOption("선택지2");
        Question q1 = Question.createQuestion(1L, "음료를 선택해주세요", "객관식", 2, a, b);

        Answer_option a2 = Answer_option.createAnswerOption("선택지1");
        Answer_option b2 = Answer_option.createAnswerOption("선택지2");
        Question q2 = Question.createQuestion(2L, "참석여부를 선택해주세요", "객관식", 2, a2, b2);

        //when
        Long SurveyId = surveyService.saveSurvey(1L, "만남장소 관련 설문조사", "동아리 만남장소 관련 설문입니다.", 1, LocalDateTime.now(),
                100L, 0, 100L, 100L, "학생", user, 1L, q1, q2);

        Survey s1 = surveyRepository.findOne(SurveyId);

        //then
        Assert.assertEquals("설문조사 생성 완료", "만남장소 관련 설문조사", s1.getTitle());
        Assert.assertEquals(2, s1.getQuestion_count());

    }
}