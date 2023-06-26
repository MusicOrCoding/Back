package com.tave.music.domain.teams;

import com.tave.music.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Teams extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    private Long id;

    @Column(nullable = false, name = "team_name", unique = true)
    private String name;

    //@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "group_type")
    private GroupType group_type;

    @Column(name = "password")
    private String password;

    @Column(name = "point")
    private Long point;



    @Builder
    public Teams(String name, GroupType group_type, String password, Long point){
        this.name = name;
        this.group_type = group_type;
        this.password = password;
        this.point = point;
    }

    public void update(String name, String password, GroupType group_type, Long point) {
        this.name = name;
        this.group_type = group_type;
        this.password = password;
        this.point = point;
    }
}
