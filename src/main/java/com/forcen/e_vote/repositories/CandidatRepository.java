package com.forcen.e_vote.repositories;

import com.forcen.e_vote.entities.Candidat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatRepository extends MongoRepository<Candidat, Long> {
    List<Candidat> findByScrutinId(Long scrutinId);

    @Query(value = "{'scrutin._id': ?0}", sort = "{'nombreVote': -1}")
    List<Candidat> findByScrutinIdOrderByVotesDesc(Long scrutinId);

    @Query(value = "{'scrutin._id': ?0}", sort = "{'position': 1}")
    List<Candidat> findByScrutinIdOrderByPosition(Long scrutinId);
}