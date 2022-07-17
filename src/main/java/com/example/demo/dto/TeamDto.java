package com.example.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TeamDto {
    private Long id;
    private String name;
    private String country;
    private List<CyclistDto> cyclists = new ArrayList<>();
}
