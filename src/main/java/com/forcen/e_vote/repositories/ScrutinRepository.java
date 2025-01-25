package com.forcen.e_vote.repositories;

import com.forcen.e_vote.entities.Scrutin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScrutinRepository extends MongoRepository<Scrutin, Long> {
    List<Scrutin> findByDateDebutBeforeAndDateFinAfter(Date now, Date now2);
    List<Scrutin> findByDateFinBefore(Date date);
    List<Scrutin> findByDateDebutAfter(Date date);

    @Query("{'dateDebut': {$lte: ?0}, 'dateFin': {$gte: ?0}}")
    List<Scrutin> findActiveScrutins(Date currentDate);
}
