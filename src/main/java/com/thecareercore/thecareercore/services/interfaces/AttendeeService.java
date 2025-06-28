package com.thecareercore.thecareercore.services.interfaces;

import com.thecareercore.thecareercore.dtos.requests.AttendeesRegistrationRequest;
import com.thecareercore.thecareercore.dtos.responses.AttendeesRegistrationResponse;
import com.thecareercore.thecareercore.exceptions.AttendeesNotFoundException;

public interface AttendeeService {
    AttendeesRegistrationResponse register(AttendeesRegistrationRequest attendeesRegistrationRequest) throws AttendeesNotFoundException;

}
