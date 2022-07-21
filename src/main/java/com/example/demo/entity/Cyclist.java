package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name="Cyclist")
@Table(name="cyclist")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cyclist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Size(max=3)
    private Long id;
    private String name;
    private String country;
    private Long teamId;
}
