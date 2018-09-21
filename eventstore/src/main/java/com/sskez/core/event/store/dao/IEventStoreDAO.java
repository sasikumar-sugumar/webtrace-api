package com.sskez.core.event.store.dao;

import com.sskez.domain.model.EntityEvent;

public interface IEventStoreDAO {


    boolean createEvents(EntityEvent entityEvent);

    boolean deleteEvents(EntityEvent entityEvent);

}
