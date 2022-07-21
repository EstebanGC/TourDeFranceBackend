package com.example.demo.controller;

import com.example.demo.dto.CyclistDto;
import com.example.demo.dto.TeamDto;
import com.example.demo.service.CyclistService;
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

    @Autowired
    private CyclistService cyclistService;

    @GetMapping("/get/all/teams")
    public List<TeamDto> getAllTeams() {
        return teamService.findAllTeams();
    }

    @PostMapping("save/team")
    public TeamDto saveTeam(@RequestBody TeamDto teamDto) {
        return teamService.createTeam(teamDto);
    }

    @PutMapping("update/team")
    public TeamDto updateTeam(@RequestBody TeamDto teamDto) {
        return teamService.updateTeam(teamDto);
    }

    @DeleteMapping("delete/team/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

    @GetMapping("/get/all/cyclists")
    public List<CyclistDto> getAllCyclists() {
        return cyclistService.findAllCyclists();
    }

    @PostMapping("save/cyclist")
    public CyclistDto saveCyclist(@RequestBody CyclistDto cyclistDto) throws Exception {
        return cyclistService.createCyclist(cyclistDto);
    }

    @PutMapping("update/cyclist")
    public CyclistDto updateCyclist(@RequestBody CyclistDto cyclistDto){
        return cyclistService.updateCyclist(cyclistDto);
    }

    @DeleteMapping("delete/cyclist/{id}")
    public void deleteCyclist(@PathVariable Long id){
        cyclistService.deleteCyclist(id);
    }
}
