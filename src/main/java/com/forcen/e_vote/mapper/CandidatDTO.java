package com.forcen.e_vote.mapper;

import com.forcen.e_vote.entities.Candidat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidatDTO {
    CandidatDTO toDTO(Candidat candidat);
    Candidat toEntity(CandidatDTO dto);
}
