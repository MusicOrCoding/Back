package com.tave.music.domain.teams;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String group_type;

    private String password;

    private Long point;

    @Builder
    public Teams(String name, String group_type, String password, Long point){
        this.name = name;
        this.group_type = group_type;
        this.password = password;
        this.point = point;
    }
}
