package com.example.demo.dto;

import com.example.demo.entity.Cyclist;
import com.example.demo.entity.Team;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public Cyclist fromCyclistDtoToEntity(CyclistDto cyclistDto){
        Cyclist cyclist = new Cyclist();
        cyclist.setTeamId(cyclistDto.getTeamId());
        cyclist.setId(cyclistDto.getId());
        cyclist.setName(cyclistDto.getName());
        cyclist.setCountry(cyclistDto.getCountry());
        return cyclist;
    }

    public CyclistDto fromEntityToCyclistDto(Cyclist cyclist) {
        CyclistDto cyclistDto = new CyclistDto();
        cyclistDto.setTeamId(cyclist.getTeamId());
        cyclistDto.setId(cyclist.getId());
        cyclistDto.setName(cyclist.getName());
        cyclistDto.setCountry(cyclist.getCountry());
        return cyclistDto;
    }

    public Team fromTeamDtoToEntity(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setName(teamDto.getName());
        team.setCountry(teamDto.getCountry());
        List<Cyclist> cyclits = new ArrayList<>();
    return team;
    }

    public TeamDto fromEntityToTeamDto(Team team) {
        List<CyclistDto> cyclists = new ArrayList<>();
        team.getCyclists().forEach(cyclist -> cyclists.add(this.fromEntityToCyclistDto(cyclist)));
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setName(team.getName());
        teamDto.setCountry(team.getCountry());
        teamDto.setCyclists(cyclists);
        return teamDto;
    }
}
