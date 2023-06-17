package com.tave.music.domain.teams;

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
public class TeamsRepositoryTest {
    @Autowired
    TeamsRepository teamsRepository;

    @After
    public void cleanup() {
        teamsRepository.deleteAll();
    }

    @Test
    public void 팀저장_불러오기() {
        //given
        String name = "팀 이름";
        String group_type = "팀 구분";
        String password = "팀 비밀번호";
        Long point = 0L;

        teamsRepository.save(Teams.builder()
                .name(name)
                .group_type(group_type)
                .password(password)
                .point(point)
                .build());

        //when
        List<Teams> teamsList = teamsRepository.findAll();

        //then
        Teams teams = teamsList.get(0);
        assertThat(teams.getName()).isEqualTo(name);
        assertThat(teams.getGroup_type()).isEqualTo(group_type);
        assertThat(teams.getPassword()).isEqualTo(password);
        assertThat(teams.getPoint()).isEqualTo(point);
    }
}
