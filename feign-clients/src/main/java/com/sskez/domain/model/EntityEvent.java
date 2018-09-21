package com.sskez.domain.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EntityEvent")
public class EntityEvent  {

    @Id
    private String Id;

    private String eventId;

    @Indexed
    private String eventName;

    private BasicDBObject payLoad;

    public EntityEvent(IEvent event) {
        this.eventId = event.getEventId();
        this.eventName = event.getEventName();
        this.payLoad = BasicDBObject.parse(new Gson().toJson(event.getPayLoad()));
    }

    public EntityEvent(String eventId) {
        this.eventId = eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public BasicDBObject getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(BasicDBObject payLoad) {
        this.payLoad = payLoad;
    }
}
