package com.forcen.e_vote.entities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;


@Data
@Document(collection = "utilisateurs")
public class Utilisateur {
    @Id
    private String id;
    private String prenom;
    private String nom;
    private String identifiant;
    private String adresse;
    private String email;
    private String telephone;
    private String statut;
    private Date dateNaissance;
    private String lieuNaissance;
    private List<Role> roles;

}

