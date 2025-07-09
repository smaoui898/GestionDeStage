package com.gestionstagiaires.crud.controller;

import com.gestionstagiaires.crud.dto.StagiaireDTO;
import com.gestionstagiaires.crud.service.StagiaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stagiaires")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StagiaireController {

    private final StagiaireService stagiaireService;

    @GetMapping
    public ResponseEntity<Page<StagiaireDTO>> getAllStagiaires(
            @PageableDefault(size = 10, sort = "nom") Pageable pageable) {
        return new ResponseEntity<>(stagiaireService.getAllStagiaires(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StagiaireDTO> getStagiaireById(@PathVariable Long id) {
        return new ResponseEntity<>(stagiaireService.getStagiaireById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StagiaireDTO> createStagiaire(@RequestBody StagiaireDTO stagiaireDTO) {
        return new ResponseEntity<>(stagiaireService.createStagiaire(stagiaireDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StagiaireDTO> updateStagiaire(
            @PathVariable Long id,
            @RequestBody StagiaireDTO stagiaireDTO) {
        return new ResponseEntity<>(stagiaireService.updateStagiaire(id, stagiaireDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStagiaire(@PathVariable Long id) {
        stagiaireService.deleteStagiaire(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
