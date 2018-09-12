package com.sskez.domain.model;

public class Event implements EventI {

    private String eventId;

    private String eventName;

    private String payLoad;

    public Event(String eventId) {
        this.eventId = eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setPayLoad(String payLoad) {
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
    public String getPayLoad() {
        return payLoad;
    }




}
