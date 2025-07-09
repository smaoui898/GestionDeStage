package com.gestionstagiaires.crud.mapper;

import com.gestionstagiaires.crud.dto.StagiaireDTO;
import com.gestionstagiaires.crud.entity.Stagiaire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StagiaireMapper {

    StagiaireDTO stagiaireToStagiaireDTO(Stagiaire stagiaire);

    Stagiaire stagiaireDTOToStagiaire(StagiaireDTO stagiaireDTO);
}