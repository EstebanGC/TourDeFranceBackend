package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Team")
@Table(name="team")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Size(max=3)
    private Long id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "teamId",
    fetch = FetchType.EAGER)
    private List<Cyclist> cyclists = new ArrayList<>();

}
