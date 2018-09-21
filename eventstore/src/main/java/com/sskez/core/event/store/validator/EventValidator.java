package com.sskez.core.event.store.validator;

import com.sskez.core.event.store.exception.ValidationException;
import com.sskez.domain.model.IEvent;
import org.apache.commons.lang.StringUtils;

public class EventValidator {

    public boolean isValid(IEvent eventRequest) throws ValidationException{
        if(eventRequest == null)
            throw new ValidationException("EventRequest is invalid.");
        if(StringUtils.isNotBlank(eventRequest.getEventId()))
            throw new ValidationException("Event ID is invalid.");
        if(StringUtils.isNotBlank(eventRequest.getEventName()))
            throw new ValidationException("Event Name is invalid.");
        if(eventRequest.getPayLoad() == null || eventRequest.getPayLoad().isEmpty())
            throw new ValidationException("PayLoad is invalid.");

        return true;

    }


}
