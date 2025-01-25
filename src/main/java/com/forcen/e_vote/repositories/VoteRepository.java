package com.forcen.e_vote.repositories;

import com.forcen.e_vote.entities.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends MongoRepository<Vote, Long> {
    @Query("{'scrutin._id': ?0, 'electeur._id': ?1}")
    Optional<Vote> findByScrutinAndElecteur(Long scrutinId, Long electeurId);

    long countByScrutinId(Long scrutinId);

    //@Query(value = "{'scrutin._id': ?0}", group = "{'_id': '$candidat._id', 'total': {$sum: 1}}")
    List<Object[]> countVotesByCandidat(Long scrutinId);

    @Query("{'dateVote': {$gte: ?0, $lte: ?1}}")
    List<Vote> findVotesBetweenDates(Date debut, Date fin);
}