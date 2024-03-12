package com.avl.damback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_assets")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_type")
    private String fileType;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "file_size")
    private Integer fileSize;
    @Column(name = "fileUrl")
    private String fileUrl;
    @Column(name = "file_extension")
    private String fileExtension;
    @Column(name = "categorie_name")
    private String categorieName;
    @JsonIgnore
    @ManyToOne
    private Categorie categorie;
}
