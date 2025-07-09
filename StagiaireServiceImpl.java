package com.gestionstagiaires.crud.service;

import com.gestionstagiaires.crud.dao.StagiaireRepository;
import com.gestionstagiaires.crud.dto.StagiaireDTO;
import com.gestionstagiaires.crud.entity.Stagiaire;
import com.gestionstagiaires.crud.mapper.StagiaireMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StagiaireServiceImpl implements StagiaireService {

    private final StagiaireRepository stagiaireRepository;
    private final StagiaireMapper stagiaireMapper;

    @Override
    public Page<StagiaireDTO> getAllStagiaires(Pageable pageable) {
        return stagiaireRepository.findAll(pageable)
                .map(stagiaireMapper::stagiaireToStagiaireDTO);
    }

    @Override
    public StagiaireDTO getStagiaireById(Long id) {
        return stagiaireRepository.findById(id)
                .map(stagiaireMapper::stagiaireToStagiaireDTO)
                .orElseThrow(() -> new RuntimeException("Stagiaire not found with id: " + id));
    }

    @Override
    public StagiaireDTO createStagiaire(StagiaireDTO stagiaireDTO) {
        if (stagiaireRepository.existsByEmail(stagiaireDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Stagiaire stagiaire = stagiaireMapper.stagiaireDTOToStagiaire(stagiaireDTO);
        Stagiaire savedStagiaire = stagiaireRepository.save(stagiaire);
        return stagiaireMapper.stagiaireToStagiaireDTO(savedStagiaire);
    }

    @Override
    public StagiaireDTO updateStagiaire(Long id, StagiaireDTO stagiaireDTO) {
        Stagiaire existingStagiaire = stagiaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stagiaire not found with id: " + id));

        if (!existingStagiaire.getEmail().equals(stagiaireDTO.getEmail()) &&
                stagiaireRepository.existsByEmail(stagiaireDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        existingStagiaire.setNom(stagiaireDTO.getNom());
        existingStagiaire.setPrenom(stagiaireDTO.getPrenom());
        existingStagiaire.setEmail(stagiaireDTO.getEmail());
        existingStagiaire.setEcole(stagiaireDTO.getEcole());
        existingStagiaire.setNiveau(stagiaireDTO.getNiveau());
        existingStagiaire.setFiliere(stagiaireDTO.getFiliere());
        existingStagiaire.setTypeStage(stagiaireDTO.getTypeStage());

        Stagiaire updatedStagiaire = stagiaireRepository.save(existingStagiaire);
        return stagiaireMapper.stagiaireToStagiaireDTO(updatedStagiaire);
    }

    @Override
    public void deleteStagiaire(Long id) {
        Stagiaire stagiaire = stagiaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stagiaire not found with id: " + id));
        stagiaireRepository.delete(stagiaire);
    }
}
