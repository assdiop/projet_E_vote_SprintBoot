package com.forcen.e_vote.repositories;


import com.forcen.e_vote.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByIdentifiant(String identifiant);
    boolean existsByEmail(String email);
    boolean existsByIdentifiant(String identifiant);
    List<User> findByStatut(String statut);
}

