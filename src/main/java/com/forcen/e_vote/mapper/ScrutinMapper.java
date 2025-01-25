package com.forcen.e_vote.mapper;

import com.forcen.e_vote.dtos.ScrutinDTO;
import com.forcen.e_vote.entities.Scrutin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScrutinMapper {

    ScrutinDTO toDTO(Scrutin scrutin);
    Scrutin toEntity(ScrutinDTO dto);
}
