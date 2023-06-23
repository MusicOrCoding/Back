package com.tave.music.controller;

import com.tave.music.domain.teams.GroupType;
import com.tave.music.domain.teams.Teams;
import com.tave.music.domain.teams.TeamsRepository;
import com.tave.music.dto.TeamsSaveRequestDto;
import com.tave.music.dto.TeamsUpdateRequestDto;
import com.tave.music.service.teams.TeamsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TeamsRepository teamsRepository;

    @After
    public void tearDown() throws Exception {
        teamsRepository.deleteAll();
    }

    @Test
    public void Teams_등록된다() throws Exception {
        //given
        String name = "name";
        GroupType group_type = GroupType.COMPANY;
        String password = "password";
        Long point = 0L;
        TeamsSaveRequestDto requestDto = TeamsSaveRequestDto.
                                                    builder()
                .name(name)
                .group_type(group_type)
                .password(password)
                .point(point)
                .build();
        String url = "http://localhost:" + port + "/team/new";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).
                isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody())
                .isGreaterThan(0L);

        List<Teams> all = teamsRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getGroup_type()).isEqualTo(group_type);
        assertThat(all.get(0).getPassword()).isEqualTo(password);

    }

    @Test
    public void Teams_수정된다() throws Exception {
        //given
        Teams savedTeams = teamsRepository.save(Teams.builder()
                .name("name")
                .group_type(GroupType.COLLEGE)
                .password("a")
                .point(100L)
                .build());

        Long updateId = savedTeams.getId();
        String expectedName = "name2";
        GroupType expectedGroupType = GroupType.COMPANY;
        String expectedPassword = "aa";
        //Long expectedPoint = 10L;

        TeamsUpdateRequestDto requestDto = TeamsUpdateRequestDto.builder()
                .name(expectedName)
                .group_type(expectedGroupType)
                .password(expectedPassword)
                .build();

        String url = "http://localhost:" + port + "/team/" + updateId;

        HttpEntity<TeamsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Teams> all = teamsRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(expectedName);
        assertThat(all.get(0).getGroup_type()).isEqualTo(expectedGroupType);
        assertThat(all.get(0).getPassword()).isEqualTo(expectedPassword);
    }

}
