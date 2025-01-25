package com.forcen.e_vote.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
//import javax.validation.constraints.*;
import java.util.Date;

@Data
public class UtilisateurDTO {
    private Long id;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "L'identifiant est obligatoire")
    private String identifiant;

    private String adresse;

    @Email(message = "Format email invalide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Format téléphone invalide")
    private String telephone;

    private String statut;

    @Past(message = "La date de naissance doit être dans le passé")
    private Date dateNaissance;

    private String lieuNaissance;
}