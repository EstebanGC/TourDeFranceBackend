package com.example.demo.service;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.Team;

import java.util.List;

public interface TeamService {

    List<TeamDto> findAllTeams();

    TeamDto createTeam(TeamDto teamDto);

    TeamDto updateTeam(TeamDto teamDto);

    void deleteTeam(Long id);
}
