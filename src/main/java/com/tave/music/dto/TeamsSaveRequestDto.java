package com.tave.music.dto;

import com.tave.music.domain.teams.Teams;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//View를 위한 클래스, Controller에서 사용
@Getter
@NoArgsConstructor
public class TeamsSaveRequestDto {
    private String name;
    private String group_type;
    private String password;
    private Long point;
    @Builder
    public TeamsSaveRequestDto(String name, String group_type, String password, Long point){
        this.name = name;
        this.group_type = group_type;
        this.password = password;
        this.point = point;
    }

    public Teams toEntity() {
        return Teams.builder()
                .name(name)
                .group_type(group_type)
                .password(password)
                .point(point)
                .build();
    }
}
