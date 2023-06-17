package com.tave.music.controller;

import com.tave.music.dto.TeamsSaveRequestDto;
import com.tave.music.service.teams.TeamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TeamsApiController {
    private final TeamsService teamsService;

    @PostMapping("/team/new")
    public Long save(@RequestBody TeamsSaveRequestDto requestDto) {
        return teamsService.save(requestDto);
    }
}
