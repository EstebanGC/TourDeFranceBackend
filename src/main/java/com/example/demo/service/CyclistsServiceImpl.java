package com.example.demo.service;

import com.example.demo.dto.CyclistDto;
import com.example.demo.dto.Mapper;
import com.example.demo.entity.Team;
import com.example.demo.repository.CyclistRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.util.BadArgumentsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CyclistsServiceImpl implements CyclistService {

    @Autowired
    private CyclistRepository cyclistRepository;

    @Autowired
    private Mapper mapper;

    @Autowired
    private TeamRepository teamRepository;


    @Override
    public List<CyclistDto> findAllCyclists(){
        List<CyclistDto> cyclistDto = new ArrayList<>();
        cyclistRepository.findAll().forEach(cyclist -> cyclistDto.add(mapper.fromEntityToCyclistDto(cyclist)));
        return cyclistDto;
    }

    @Override
    public CyclistDto createCyclist(CyclistDto cyclistDto) throws Exception {
        Optional<Team> teamResponse = teamRepository.findById(cyclistDto.getTeamId());
        if (teamResponse.get().getCyclists().size()<8){
            return mapper.fromEntityToCyclistDto(cyclistRepository.save(mapper.fromCyclistDtoToEntity(cyclistDto)));
        } else {
            throw new BadArgumentsException("The team is full of cyclists. You can not add more.");
        }
    }

    @Override
    public CyclistDto updateCyclist(CyclistDto cyclistDto) {
        return mapper.fromEntityToCyclistDto(cyclistRepository.save(mapper.fromCyclistDtoToEntity(cyclistDto)));
    }

    @Override
    public void deleteCyclist(Long id) {
        cyclistRepository.deleteById(id);
    }


}
