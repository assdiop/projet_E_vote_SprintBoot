package com.forcen.e_vote.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "candidats")
public class Candidat {
    @Id
    private Long id;
    private String libelle;
    private String photo;
    private String description;
    private int position;
    private long nombreVote;
    private Scrutin scrutin;
}

