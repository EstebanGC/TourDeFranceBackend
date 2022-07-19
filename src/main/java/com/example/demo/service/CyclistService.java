package com.example.demo.service;

import com.example.demo.dto.CyclistDto;
import com.example.demo.entity.Cyclist;

import java.util.List;

public interface CyclistService {

    List<CyclistDto> findAllCyclists();

    CyclistDto createCyclist(CyclistDto cyclistDto);

    CyclistDto updateCyclist(CyclistDto cyclistDto);

    void deleteCyclist(Long id);

}
