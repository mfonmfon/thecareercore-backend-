package com.thecareercore.thecareercore.services.implimentation;

import com.thecareercore.thecareercore.domain.model.Attendees;
import com.thecareercore.thecareercore.domain.repository.AttendeesRepository;
import com.thecareercore.thecareercore.dtos.requests.AttendeesRegistrationRequest;
import com.thecareercore.thecareercore.dtos.responses.AttendeesRegistrationResponse;
import com.thecareercore.thecareercore.exceptions.AttendeeAlreadyExistException;
import com.thecareercore.thecareercore.exceptions.AttendeesNotFoundException;
import com.thecareercore.thecareercore.exceptions.InvalidCredentialException;
import com.thecareercore.thecareercore.exceptions.InvalidFieldsException;
import com.thecareercore.thecareercore.services.interfaces.AttendeeService;
import com.thecareercore.thecareercore.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static com.thecareercore.thecareercore.dtos.responses.AppResponse.*;


@Service
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeesRepository attendeesRepository;
    private static final Pattern PHONE_NUMBER_REGEX_VALIDATOR = Pattern.compile("\"^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern ATTENDEES_EMAIL_REGEX_VALIDATOR = Pattern.compile("\"^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Mapper mapper = new Mapper();

    public AttendeeServiceImpl(AttendeesRepository attendeesRepository) {
        this.attendeesRepository = attendeesRepository;
    }

    @Override
    public AttendeesRegistrationResponse register(AttendeesRegistrationRequest attendeesRegistrationRequest) throws AttendeesNotFoundException {
        validateAttendeesEmail(attendeesRegistrationRequest.getEmail());
        mapper.validateAttendeesInputs(attendeesRegistrationRequest.getFirstName(),
                attendeesRegistrationRequest.getLastName(), attendeesRegistrationRequest.getEmail(),
                attendeesRegistrationRequest.getOccupation(), attendeesRegistrationRequest.getPhoneNumber());
        Attendees attendees = buildAttendees(attendeesRegistrationRequest);
        attendeesRepository.save(attendees);
        AttendeesRegistrationResponse registrationResponse = new AttendeesRegistrationResponse();
        registrationResponse.setSuccessCode(ATTENDEES_REGISTRATION_SUCCESS_MESSAGE.getMessage());
        return registrationResponse;
    }

    private Attendees buildAttendees(AttendeesRegistrationRequest attendeesRegistrationRequest) {
        Attendees attendees = new Attendees();
        attendees.setFirstName(attendeesRegistrationRequest.getFirstName());
        attendees.setLastName(attendeesRegistrationRequest.getLastName());
        attendees.setEmail(validateEmailRex(attendeesRegistrationRequest.getEmail()));
        attendees.setPhoneNumber(validateAttendeesPhoneNumber(attendeesRegistrationRequest.getPhoneNumber()));
        attendees.setOccupation(attendeesRegistrationRequest.getOccupation());
        return attendees;
    }

    private String validateAttendeesPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches(PHONE_NUMBER_REGEX_VALIDATOR.pattern()))
            throw new InvalidCredentialException("Invalid phone number");
        return phoneNumber;
    }

    private String validateEmailRex(String email) {
        if (email == null || ATTENDEES_EMAIL_REGEX_VALIDATOR.matcher(email).matches()){
            throw new InvalidCredentialException("Wrong email or password");
        }
        return email;
    }

    private void validateAttendeesEmail(String email){
        boolean isAttendeesEmail = attendeesRepository.findByEmail(email);
        if (isAttendeesEmail)
            throw new AttendeeAlreadyExistException(ATTENDEES_ALREADY_EXIST_EXCEPTION.getMessage());

    }

}