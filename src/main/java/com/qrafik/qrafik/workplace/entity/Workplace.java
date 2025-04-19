package com.qrafik.qrafik.workplace.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workplaces")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
