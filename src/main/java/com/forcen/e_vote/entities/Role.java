package com.forcen.e_vote.entities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "roles")
public class Role {
    @Id
    private Long id;
    private String libelle;
}


