package com.example.demo.service;

import com.example.demo.dto.TeamDto;
import com.example.demo.repository.CyclistRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.dto.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CyclistRepository cyclistRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<TeamDto> findAllTeams() {
        List<TeamDto> teamDto = new ArrayList<>();
        teamRepository.findAll().forEach(team -> teamDto.add(mapper.fromEntityToTeamDto(team)));
        return teamDto;
    }

    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        return mapper.fromEntityToTeamDto(teamRepository.save(mapper.fromTeamDtoToEntity(teamDto)));
    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto) {
        return mapper.fromEntityToTeamDto(teamRepository.save(mapper.fromTeamDtoToEntity(teamDto)));
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
