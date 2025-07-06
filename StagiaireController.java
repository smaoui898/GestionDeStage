package com.gestionstagiaires.crud.controller;

import com.gestionstagiaires.crud.entity.Stagiaire;
import com.gestionstagiaires.crud.service.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stagiaires")
@CrossOrigin(origins = "http://localhost:4200")
public class StagiaireController {

    private final StagiaireService stagiaireService;

    @Autowired
    public StagiaireController(StagiaireService stagiaireService) {
        this.stagiaireService = stagiaireService;
    }

    @GetMapping
    public ResponseEntity<List<Stagiaire>> getAllStagiaires() {
        List<Stagiaire> stagiaires = stagiaireService.getAllStagiaires();
        return new ResponseEntity<>(stagiaires, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stagiaire> getStagiaireById(@PathVariable Long id) {
        Stagiaire stagiaire = stagiaireService.getStagiaireById(id);
        return new ResponseEntity<>(stagiaire, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Stagiaire> createStagiaire(@RequestBody Stagiaire stagiaire) {
        Stagiaire createdStagiaire = stagiaireService.createStagiaire(stagiaire);
        return new ResponseEntity<>(createdStagiaire, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stagiaire> updateStagiaire(
            @PathVariable Long id,
            @RequestBody Stagiaire stagiaire) {
        Stagiaire updatedStagiaire = stagiaireService.updateStagiaire(id, stagiaire);
        return new ResponseEntity<>(updatedStagiaire, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStagiaire(@PathVariable Long id) {
        stagiaireService.deleteStagiaire(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}