package com.sskez.core.event.store.controller;

import com.sskez.core.event.store.dao.IEventStoreDAO;
import com.sskez.domain.exception.ValidationException;
import com.sskez.domain.model.EntityEvent;
import com.sskez.domain.model.EventRequest;
import com.sskez.domain.model.IEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventStoreController {

    private static final Logger log = LoggerFactory.getLogger(EventStoreController.class);


    @Autowired
    private IEventStoreDAO eventStoreDAO;

    @RequestMapping(value = "/getValue",method = RequestMethod.GET)
    public String getValue(){
        return "ALL NODE";
    }

    @RequestMapping(value = "/context/event/publish",method = RequestMethod.POST)
    public IEvent publish(@RequestBody IEvent entityEvent) throws ValidationException {
        log.info("entry publish events");
        entityEvent.isValid();
        eventStoreDAO.createEvents(new EntityEvent(entityEvent) );
        log.info("exit publish events");
        return entityEvent;
    }



}
