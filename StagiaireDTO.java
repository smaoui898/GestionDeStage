package com.gestionstagiaires.crud.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StagiaireDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String ecole;
    private String niveau;
    private String filiere;
    private String typeStage;
}