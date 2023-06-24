package com.tave.music.domain.teams;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static com.tave.music.domain.teams.GroupType.COMPANY;
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
        GroupType group_type = COMPANY;
        String password = "팀 비밀번호";
        Long point = 0L;

        teamsRepository.save(Teams.builder()  //테이블 Teams에 insert/update 쿼리를 실행. id 값이 있다면 update가, 없다면 insert 쿼리가 실행됨.
                .name(name)
                .group_type(GroupType.valueOf(String.valueOf(group_type)))
                .password(password)
                .point(point)
                .build());

        //when
        //테이블 Teams에 있는 모든 데이터를 조회해오는 메소드.
        List<Teams> teamsList = teamsRepository.findAll();

        //then
        Teams teams = teamsList.get(0);
        assertThat(teams.getName()).isEqualTo(name);
        assertThat(teams.getGroup_type()).isEqualTo(group_type);
        assertThat(teams.getPassword()).isEqualTo(password);
        assertThat(teams.getPoint()).isEqualTo(point);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2023,6,24,0,0,0);
        teamsRepository.save(Teams.builder()
                .name("name")
                .group_type(GroupType.valueOf("COMPANY"))
                .password("a")
                .point(100L)
                .build());

        //when
        List<Teams> teamsList = teamsRepository.findAll();

        //then
        Teams teams = teamsList.get(0);

        System.out.println(">>>>>>> createdDate="+teams.getCreatedDate()+", modifiedDate="+teams.getModifiedDate());

        assertThat(teams.getCreatedDate()).isAfter(now);
        assertThat(teams.getModifiedDate()).isAfter(now);
    }
}
