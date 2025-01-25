package com.forcen.e_vote.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CandidatDTO {
    private String id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @NotBlank(message = "Le parti est obligatoire")
    private String parti;

    @Size(max = 1000, message = "Le programme ne doit pas dépasser 1000 caractères")
    private String programme;

    private String photo;
}