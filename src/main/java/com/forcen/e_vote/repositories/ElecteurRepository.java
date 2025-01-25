package com.forcen.e_vote.repositories;


import com.forcen.e_vote.entities.Electeur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElecteurRepository extends MongoRepository<Electeur, Long> {
    @Query("{'votes.scrutin._id': ?0}")
    List<Electeur> findByScrutinId(Long scrutinId);

    @Query(value = "{'votes': {$not: {$elemMatch: {'scrutin._id': ?0}}}}")
    List<Electeur> findElecteursNonVotants(Long scrutinId);

    long countByStatut(String statut);
}