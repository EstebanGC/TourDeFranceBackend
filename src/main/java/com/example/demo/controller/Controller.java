package com.example.demo.controller;

import com.example.demo.dto.TeamDto;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class Controller {
    @Autowired
    private TeamService teamService;

    @GetMapping("/get/all/teams")
    public List<TeamDto> getAllTeams() {
        return teamService.findAllTeams();
    }
    @PostMapping("save/team")
    public TeamDto saveTeam(@RequestBody TeamDto teamDto) {
        return teamService.createTeam(teamDto);
    }

    @DeleteMapping("update/team/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}
