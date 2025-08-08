package com.thecareercore.thecareercore.services.implimentation;

import com.thecareercore.thecareercore.domain.model.Sponsors;
import com.thecareercore.thecareercore.domain.repository.SponsorsRepository;
import com.thecareercore.thecareercore.dtos.requests.BecomeASponsorRequest;
import com.thecareercore.thecareercore.dtos.responses.BecomeASponsorResponse;
import com.thecareercore.thecareercore.exceptions.AttendeeAlreadyExistException;
import com.thecareercore.thecareercore.exceptions.InvalidCredentialException;
import com.thecareercore.thecareercore.services.interfaces.SponsorService;
import com.thecareercore.thecareercore.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static com.thecareercore.thecareercore.dtos.responses.AppResponse.ATTENDEES_ALREADY_EXIST_EXCEPTION;
import static com.thecareercore.thecareercore.dtos.responses.AppResponse.SUCCESS_MESSAGE;

@Service
public class SponsorServiceImpl implements SponsorService {
    private static final Pattern PHONE_NUMBER_REGEX_VALIDATOR = Pattern.compile("^(\\\\+234|0)[789][01]\\\\d{8}$");
    private static final Pattern ATTENDEES_EMAIL_REGEX_VALIDATOR = Pattern.compile("\"^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Mapper mapper = new Mapper();
    private final SponsorsRepository sponsorsRepository;

    public SponsorServiceImpl(SponsorsRepository sponsorsRepository) {
        this.sponsorsRepository = sponsorsRepository;
    }

    @Override
    public BecomeASponsorResponse becomeSponsor(BecomeASponsorRequest becomeASponsor) {
        Sponsors sponsors = buildSponsorsRequest(becomeASponsor);
        validateAttendeesEmail(becomeASponsor.getCompanyEmail());
        mapper.validateSponsorInput(becomeASponsor.getFirstName(), becomeASponsor.getLastName(),
                becomeASponsor.getCompanyName(), becomeASponsor.getCompanyDescription(),
                becomeASponsor.getCompanyEmail(), becomeASponsor.getPhoneNumber(),
                becomeASponsor.getWhereYouHeardCareerCore());
        sponsorsRepository.save(sponsors);
        BecomeASponsorResponse becomeASponsorResponse = new BecomeASponsorResponse();
        becomeASponsorResponse.setMessage(SUCCESS_MESSAGE.getMessage());
        becomeASponsorResponse.setStatusCode("SUCCESS");
        return becomeASponsorResponse;
    }
    private Sponsors buildSponsorsRequest(BecomeASponsorRequest becomeASponsor) {
        Sponsors sponsors = new Sponsors();
        sponsors.setFirstName(becomeASponsor.getFirstName());
        sponsors.setLastName(becomeASponsor.getLastName());
        sponsors.setCompanyName(becomeASponsor.getCompanyName());
        sponsors.setCompanyDescription(becomeASponsor.getCompanyDescription());
        sponsors.setPhoneNumber(validateAttendeesPhoneNumber(becomeASponsor.getPhoneNumber()));
        sponsors.setCompanyEmail(validateEmailRex(becomeASponsor.getCompanyEmail()));
        sponsors.setWhereYouHeardCareerCore(becomeASponsor.getWhereYouHeardCareerCore());
        return sponsors;
    }
    private String validateAttendeesPhoneNumber(String phoneNumber) {
        if (PHONE_NUMBER_REGEX_VALIDATOR.matcher(phoneNumber).matches()){
            throw new InvalidCredentialException("Invalid phone number");
        }
        return phoneNumber;
    }
    private String validateEmailRex(String email) {
        if (email == null || ATTENDEES_EMAIL_REGEX_VALIDATOR.matcher(email).matches()){
            throw new InvalidCredentialException("Wrong email or password");
        }
        return email;
    }
    private void validateAttendeesEmail(String email){
        boolean isAttendeesEmail = sponsorsRepository.existsByCompanyEmail(email);
        if (isAttendeesEmail)
            throw new AttendeeAlreadyExistException(ATTENDEES_ALREADY_EXIST_EXCEPTION.getMessage());
    }
}