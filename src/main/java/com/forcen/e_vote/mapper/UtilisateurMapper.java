package com.forcen.e_vote.mapper;

    import com.forcen.e_vote.dtos.CandidatDTO;
    import com.forcen.e_vote.dtos.ScrutinDTO;
    import com.forcen.e_vote.dtos.UtilisateurDTO;

    import com.forcen.e_vote.entities.Scrutin;
    import com.forcen.e_vote.entities.Utilisateur;

    //MapStruct Mapper
    import org.mapstruct.Mapper;
    import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    UtilisateurDTO toDTO(Utilisateur utilisateur);
    Utilisateur toEntity(UtilisateurDTO dto);


}