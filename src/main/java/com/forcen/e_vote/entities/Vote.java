package com.forcen.e_vote.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "votes")
public class Vote {
    @Id
    private Long id;
    private Electeur electeur;
    private Scrutin scrutin;
    private Candidat candidat;
    private Date dateVote;
}
