package com.gestionstagiaires.crud.service;

import com.gestionstagiaires.crud.dao.StagiaireRepository;
import com.gestionstagiaires.crud.entity.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StagiaireServiceImpl implements StagiaireService {

    private final StagiaireRepository stagiaireRepository;

    @Autowired
    public StagiaireServiceImpl(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;
    }

    @Override
    public List<Stagiaire> getAllStagiaires() {
        return stagiaireRepository.findAll();
    }

    @Override
    public Stagiaire getStagiaireById(Long id) {
        Optional<Stagiaire> stagiaire = stagiaireRepository.findById(id);
        return stagiaire.orElseThrow(() ->
                new RuntimeException("Stagiaire not found with id: " + id));
    }

    @Override
    public Stagiaire createStagiaire(Stagiaire stagiaire) {
        if (stagiaireRepository.existsByEmail(stagiaire.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return stagiaireRepository.save(stagiaire);
    }

    @Override
    public Stagiaire updateStagiaire(Long id, Stagiaire stagiaireDetails) {
        Stagiaire stagiaire = getStagiaireById(id);

        // Check if email is being changed to an existing email
        if (!stagiaire.getEmail().equals(stagiaireDetails.getEmail())) {
            if (stagiaireRepository.existsByEmail(stagiaireDetails.getEmail())) {
                throw new RuntimeException("Email already exists");
            }
        }

        stagiaire.setNom(stagiaireDetails.getNom());
        stagiaire.setPrenom(stagiaireDetails.getPrenom());
        stagiaire.setEmail(stagiaireDetails.getEmail());
        stagiaire.setEcole(stagiaireDetails.getEcole());
        stagiaire.setNiveau(stagiaireDetails.getNiveau());
        stagiaire.setFiliere(stagiaireDetails.getFiliere());
        stagiaire.setTypeStage(stagiaireDetails.getTypeStage());

        return stagiaireRepository.save(stagiaire);
    }

    @Override
    public void deleteStagiaire(Long id) {
        Stagiaire stagiaire = getStagiaireById(id);
        stagiaireRepository.delete(stagiaire);
    }
}