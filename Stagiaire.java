package com.gestionstagiaires.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stagiaires")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String ecole;

    @Column(nullable = false)
    private String niveau;

    @Column(nullable = false)
    private String filiere;

    @Column(name = "type_stage", nullable = false)
    private String typeStage;
}
