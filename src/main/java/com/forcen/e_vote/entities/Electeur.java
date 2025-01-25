package com.forcen.e_vote.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "electeurs")
public class Electeur extends Utilisateur {
    private List<Vote> votes;
}