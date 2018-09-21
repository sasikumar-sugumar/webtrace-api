package com.sskez.domain.model;

import com.sskez.domain.exception.ValidationException;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public interface IEvent {
    String getEventId();

    String getEventName();

    Map<String,Object> getPayLoad();



    public default boolean isValid() throws ValidationException {

        if(StringUtils.isNotBlank(getEventId()))
            throw new ValidationException("Event ID is invalid.");
        if(StringUtils.isNotBlank(getEventName()))
            throw new ValidationException("Event Name is invalid.");
        if(getPayLoad() == null || getPayLoad().isEmpty())
            throw new ValidationException("PayLoad is invalid.");

        return true;

    }
}
