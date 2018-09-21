package com.sskez.domain.model;

import java.util.Map;

public class EventRequest implements IEvent{

    private String eventId;

    private String eventName;

    private Map<String,Object> payLoad;

    public EventRequest() {
    }

    public EventRequest(String eventId) {
        this.eventId = eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setPayLoad(Map<String,Object>  payLoad) {
        this.payLoad = payLoad;
    }

    @Override
    public String getEventId() {
        return eventId;
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    @Override
    public Map<String,Object>  getPayLoad() {
        return payLoad;
    }

}
