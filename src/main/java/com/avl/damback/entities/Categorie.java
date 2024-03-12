package com.avl.damback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;

    private String description;
    private int code;
    private String imageUrl;
    private LocalDateTime createdAt;
    private String createdBy;
    @OneToMany(mappedBy = "categorie" )
    private List<Assets> assets;
}
