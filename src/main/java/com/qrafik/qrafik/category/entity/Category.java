package com.qrafik.qrafik.category.entity;

import com.qrafik.qrafik.workplace.entity.Workplace;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    //TODO : add image url

    @ManyToOne
    @JoinColumn(name = "workplace_id")
    private Workplace workplace;
}
