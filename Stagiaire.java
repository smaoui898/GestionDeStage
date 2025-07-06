package com.gestionstagiaires.crud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stagiaires")
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

    // Constructors
    public Stagiaire() {}

    public Stagiaire(String nom, String prenom, String email, String ecole,
                     String niveau, String filiere, String typeStage) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.ecole = ecole;
        this.niveau = niveau;
        this.filiere = filiere;
        this.typeStage = typeStage;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getTypeStage() {
        return typeStage;
    }

    public void setTypeStage(String typeStage) {
        this.typeStage = typeStage;
    }
}