package com.gestionstagiaires.crud.service;

import com.gestionstagiaires.crud.dto.StagiaireDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StagiaireService {
    Page<StagiaireDTO> getAllStagiaires(Pageable pageable);
    StagiaireDTO getStagiaireById(Long id);
    StagiaireDTO createStagiaire(StagiaireDTO stagiaireDTO);
    StagiaireDTO updateStagiaire(Long id, StagiaireDTO stagiaireDTO);
    void deleteStagiaire(Long id);
}
