package com.example.demo.entity;


import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Team")
@Table(name="team")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "teamId",
    fetch = FetchType.EAGER)
    private List<Cyclist> cyclists = new ArrayList<>();

}
