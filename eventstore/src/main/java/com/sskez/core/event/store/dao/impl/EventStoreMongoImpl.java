package com.sskez.core.event.store.dao.impl;

import com.sskez.core.event.store.dao.IEventStoreDAO;
import com.sskez.domain.model.EntityEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventStoreMongoImpl implements IEventStoreDAO {

    private static final Logger log = LoggerFactory.getLogger(EventStoreMongoImpl.class);


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean createEvents(EntityEvent entityEvent) {
        log.info("entry createEvents");
        mongoTemplate.save(entityEvent);
        log.info("exit createEvents");
        return true;
    }

    @Override
    public boolean deleteEvents(EntityEvent entityEvent) {
        log.info("entry deleteEvents");
        mongoTemplate.remove(entityEvent);
        log.info("exit deleteEvents");
        return true;
    }
}
