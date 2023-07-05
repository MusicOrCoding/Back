package com.tave.music.domain.survey;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyRepositoryTest {

    @Autowired
    SurveyRepository surveyRepository;
//
//    @After
//    public void cleanup() {
//        surveyRepository.deleteAll();
//    }

//    public void createSurveyList(){
//        for(int i = 0; i <= 10; i++){
//            String title = "테스트 설문조사" + i;
//            String content = "테스트 본문" + i;
//
//            Survey survey = new Survey();
//            survey.builder()
//                    .title(title)
//                    .content(content)
//                    .build();
//            Survey savedSurvey = surveyRepository.save(survey);
//        }
//    }
//
//    @Test
//    public void 설문조사저장_불러오기() {
//        //given
//        String title = "테스트 설문조사";
//        String content = "테스트 본문";
//
//        surveyRepository.save(Survey.builder()
//                .title(title)
//                .content(content)
//                .build());
//
//        //when
//        List<Survey> surveyList = surveyRepository.findAll();
//
//        //then
//        Survey surveys = surveyList.get(0);
//        assertThat(surveys.getTitle()).isEqualTo(title);
//        assertThat(surveys.getContent()).isEqualTo(content);
//    }
//
//    @Test
//    public void findBySurveyTitle(){
//        this.createSurveyList();
//        List<Survey> surveyList = surveyRepository.findByTitle("테스트 설문조사1");
//
//        for(Survey survey: surveyList) {
//            System.out.println(survey.toString());
//        }
//    }
}
