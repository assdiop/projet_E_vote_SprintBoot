package com.forcen.e_vote.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data

@Document(collection = "scrutins")
public class Scrutin {
    @Id
    private Long id;
    private String titre;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private List<Candidat> candidats;
    private List<Vote> votes;
}
