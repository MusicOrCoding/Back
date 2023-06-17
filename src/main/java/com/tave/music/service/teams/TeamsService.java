package com.tave.music.service.teams;

import com.tave.music.domain.teams.TeamsRepository;
import com.tave.music.dto.TeamsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TeamsService {
    private final TeamsRepository teamsRepository;

    @Transactional
    public Long save(TeamsSaveRequestDto requestDto){
        return teamsRepository.save(requestDto.toEntity()).getId();
    }
}
