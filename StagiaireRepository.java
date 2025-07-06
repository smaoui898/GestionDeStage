package com.gestionstagiaires.crud.dao;

import com.gestionstagiaires.crud.entity.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
    // Custom query methods can be added here
    boolean existsByEmail(String email);
}