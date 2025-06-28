package com.thecareercore.thecareercore.services.implimentation;

import com.thecareercore.thecareercore.domain.model.Attendees;
import com.thecareercore.thecareercore.domain.repository.AttendeesRepository;
import com.thecareercore.thecareercore.dtos.requests.AttendeesRegistrationRequest;
import com.thecareercore.thecareercore.dtos.responses.AttendeesRegistrationResponse;
import com.thecareercore.thecareercore.exceptions.AttendeesNotFoundException;
import com.thecareercore.thecareercore.services.interfaces.AttendeeService;
import org.springframework.stereotype.Service;

import static com.thecareercore.thecareercore.dtos.responses.AppResponse.ATTENDEES_NOT_FOUND_EXCEPTION;
import static com.thecareercore.thecareercore.dtos.responses.AppResponse.ATTENDEES_REGISTRATION_SUCCESS_MESSAGE;


@Service
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeesRepository attendeesRepository;

    public AttendeeServiceImpl(AttendeesRepository attendeesRepository) {
        this.attendeesRepository = attendeesRepository;
    }

    @Override
    public AttendeesRegistrationResponse register(AttendeesRegistrationRequest attendeesRegistrationRequest) throws AttendeesNotFoundException {
        Attendees attendees = new Attendees();
        attendees.setFirstName(attendeesRegistrationRequest.getFirstName());
        attendees.setLastName(attendeesRegistrationRequest.getLastName());
        attendees.setEmail(attendeesRegistrationRequest.getEmail());
        attendees.setPhoneNumber(attendeesRegistrationRequest.getPhoneNumber());
        attendees.setOccupation(attendeesRegistrationRequest.getOccupation());
        attendeesRepository.save(attendees);
        AttendeesRegistrationResponse registrationResponse = new AttendeesRegistrationResponse();
        registrationResponse.setSuccessCode(ATTENDEES_REGISTRATION_SUCCESS_MESSAGE.getMessage());
        return registrationResponse;
    }
}