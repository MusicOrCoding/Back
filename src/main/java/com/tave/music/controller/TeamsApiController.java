package com.tave.music.controller;

import com.tave.music.dto.TeamsResponseDto;
import com.tave.music.dto.TeamsSaveRequestDto;
import com.tave.music.dto.TeamsUpdateRequestDto;
import com.tave.music.service.teams.TeamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TeamsApiController {
    private final TeamsService teamsService;

    @PostMapping("/team/new")
    public Long save(@RequestBody TeamsSaveRequestDto requestDto) {
        return teamsService.save(requestDto);
    }

    @PutMapping("/team/{id}")
    public Long update(@PathVariable Long id, @RequestBody TeamsUpdateRequestDto requestDto) {
        return teamsService.update(id, requestDto);
    }


    @GetMapping("/team/{id}")
    public TeamsResponseDto findById (@PathVariable Long id) {
        return teamsService.findById(id);
    }

    @DeleteMapping("/team/{id}")
    public Long delete(@PathVariable Long id) {
        teamsService.delete(id);
        return id;
    }
}
