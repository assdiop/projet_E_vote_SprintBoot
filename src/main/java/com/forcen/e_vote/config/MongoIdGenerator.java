package com.forcen.e_vote.config;

import com.forcen.e_vote.entities.DatabaseSequence;
import com.forcen.e_vote.entities.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class MongoIdGenerator extends AbstractMongoEventListener<Object> {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object entity = event.getSource();
        if (entity instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) entity;
            if (baseEntity.getId() == null) {
                baseEntity.setId(generateSequence(entity.getClass().getSimpleName()));
            }
        }
    }

    private long generateSequence(String seqName) {
        DatabaseSequence counter = mongoOperations.findAndModify(
                Query.query(where("_id").is(seqName)), // Requête pour chercher le compteur
                new Update().inc("seq", 1),            // Incrémentation de la valeur
                options().returnNew(true).upsert(true), // Retourne la nouvelle valeur, crée une entrée si inexistante
                DatabaseSequence.class
        );

        // Vérifie si le compteur est nul et retourne 1 par défaut
        return counter != null ? counter.getSeq() : 1;
    }
}
