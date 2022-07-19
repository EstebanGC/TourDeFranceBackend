package com.example.demo.service;

import com.example.demo.dto.CyclistDto;
import com.example.demo.dto.Mapper;
import com.example.demo.repository.CyclistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CyclistsServiceImpl implements CyclistService {

    @Autowired
    private CyclistRepository cyclistRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<CyclistDto> findAllCyclists(){
        List<CyclistDto> cyclistDto = new ArrayList<>();
        cyclistRepository.findAll().forEach(cyclist -> cyclistDto.add(mapper.fromEntityToCyclistDto(cyclist)));
        return cyclistDto;
    }

    @Override
    public CyclistDto createCyclist(CyclistDto cyclistDto){
        return mapper.fromEntityToCyclistDto(cyclistRepository.save(mapper.fromCyclistDtoToEntity(cyclistDto)));
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
