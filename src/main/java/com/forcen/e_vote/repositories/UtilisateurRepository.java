package com.forcen.e_vote.repositories;


import com.forcen.e_vote.entities.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByIdentifiant(String identifiant);
    boolean existsByEmail(String email);
    boolean existsByIdentifiant(String identifiant);
    List<Utilisateur> findByStatut(String statut);
}

