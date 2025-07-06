package com.gestionstagiaires.crud.service;

import com.gestionstagiaires.crud.entity.Stagiaire;
import java.util.List;

public interface StagiaireService {
    List<Stagiaire> getAllStagiaires();
    Stagiaire getStagiaireById(Long id);
    Stagiaire createStagiaire(Stagiaire stagiaire);
    Stagiaire updateStagiaire(Long id, Stagiaire stagiaire);
    void deleteStagiaire(Long id);
}