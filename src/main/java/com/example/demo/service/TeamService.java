package com.example.demo.service;

import com.example.demo.dto.TeamDto;

import java.util.List;

public interface TeamService {

    List<TeamDto> findAllTeams();

    TeamDto createTeam(TeamDto teamDto);

    void deleteTeam(Long id);
}
