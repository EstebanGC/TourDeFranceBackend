package com.example.demo.testservice;

import com.example.demo.dto.CyclistDto;
import com.example.demo.dto.Mapper;
import com.example.demo.dto.TeamDto;
import com.example.demo.entity.Cyclist;
import com.example.demo.entity.Team;
import com.example.demo.repository.CyclistRepository;
import com.example.demo.repository.TeamRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import javax.swing.text.html.Option;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamRepository teamRepository;

    @MockBean
    private CyclistRepository cyclistRepository;

    @MockBean
    private Mapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllTeamsSuccesfull() throws Exception {
        Team team = new Team(67L,"X","X",List.of(new Cyclist(25L,"Y","Y", 2L)));
        List<Team> teams = new ArrayList<>();
        teams.add(team);
        when(teamRepository.findAll()).thenReturn(teams);
        this.mockMvc.perform(get("/get/all/teams")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getAllCyclistSuccesfull() throws Exception {
        Cyclist cyclist = new Cyclist(25L,"Y","Y", 2L);
        List<Cyclist> cyclists = new ArrayList<>();
        cyclists.add(cyclist);
        when(cyclistRepository.findAll()).thenReturn(cyclists);
        this.mockMvc.perform(get("/get/all/cyclists")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void saveCyclistSuccesfull() throws Exception {
        CyclistDto cyclistDto = new CyclistDto(56L, "W", "W", 89L);
        Cyclist cyclist = new Cyclist(56L, "W", "W", 89L);
        List<Cyclist> cyclists = new ArrayList<>();
        cyclists.add(cyclist);
        Team team = new Team(67L,"X","X",List.of(new Cyclist(25L,"Y","Y", 2L)));
        when(teamRepository.findById(cyclistDto.getTeamId())).thenReturn(Optional.of(team));
        when(mapper.fromCyclistDtoToEntity(cyclistDto)).thenReturn(cyclist);
        when(cyclistRepository.save(cyclist)).thenReturn(cyclist);
        this.mockMvc.perform(post("/save/cyclist").content(objectMapper.writeValueAsString(cyclistDto))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void teamFullSuccesfull() throws Exception {
        CyclistDto cyclistDto = new CyclistDto(56L, "W", "W", 89L);
        Cyclist cyclist = new Cyclist(56L, "W", "W", 89L);
        List<Cyclist> cyclists = new ArrayList<>();
        cyclists.add(cyclist);
        for (int i = 0; i < 8; i++) {
            cyclists.add(new Cyclist(56L, "W", "W", 89L));
        }
        Team team = new Team(67L,"X","X",cyclists);
        when(teamRepository.findById(cyclistDto.getTeamId())).thenReturn(Optional.of(team));
        when(mapper.fromCyclistDtoToEntity(cyclistDto)).thenReturn(cyclist);
        when(cyclistRepository.save(cyclist)).thenReturn(cyclist);
        this.mockMvc.perform(post("/save/cyclist").content(objectMapper.writeValueAsString(cyclistDto))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isBadRequest());
    }
}
