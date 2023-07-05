//package com.tave.music.controller;
//
//import com.tave.music.domain.survey.Survey;
//import com.tave.music.domain.survey.SurveyRepository;
//
//import org.apache.coyote.Response;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class SurveyApiControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private SurveyRepository surveyRepository;
//
//    @After
//    public void tearDown() throws Exception {
//        surveyRepository.deleteAll();
//    }
//
//    @Test
//    public void Survey_등록된다() throws Exception {
//        //given
//        String title = "설문조사";
//
//        String content="음료 선택";
//
//        int is_team = 0;
//
//        Long question_count = 1000L;
//
//        //LocalDateTime deadline_date = 2000;
//
//        Long max_participants = 100L;
//
//        int is_over = 0;
//
//        Long reward_point = 10L;
//
//        Long cost_point = 20L;
//
//        String target = "학생";
//
//        Long user_id = 100L;
//
//        Long team_id = 1L;
//        SurveySaveRequestDto requestDto = SurveySaveRequestDto.builder()
//                .title(title)
//                .content(content)
//                .is_team(is_team)
//                .question_count(question_count)
//                //.deadline_date(deadline_date)
//                .max_participants(max_participants)
//                .is_over(is_over)
//                .reward_point(reward_point)
//                .cost_point(cost_point)
//                .target(target)
//                .user_id(user_id)
//                .team_id(team_id)
//                .build();
//
//        String url = "http://localhost:" + port + "/survey/new";
//
//        //when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Survey> all = surveyRepository.findAll();
//        assertThat(all.get(0).getTitle()).isEqualTo(title);
//        assertThat(all.get(0).getContent()).isEqualTo(content);
//
//    }
//
//}
