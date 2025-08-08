package com.thecareercore.thecareercore;

import com.thecareercore.thecareercore.domain.repository.AttendeesRepository;
import com.thecareercore.thecareercore.dtos.requests.AttendeesRegistrationRequest;
import com.thecareercore.thecareercore.dtos.requests.BecomeASponsorRequest;
import com.thecareercore.thecareercore.dtos.responses.AttendeesRegistrationResponse;
import com.thecareercore.thecareercore.dtos.responses.BecomeASponsorResponse;
import com.thecareercore.thecareercore.services.interfaces.AttendeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AttendeeServiceTest {

    @Autowired
    private AttendeeService attendeeService;
    @Autowired
    private AttendeesRepository attendeesRepository;


    @Test
    public void testThatAttendeesCanRegisterForTheEvent(){
        AttendeesRegistrationRequest attendeesRegistrationRequest = attendeesRequestPayLoad();
        AttendeesRegistrationResponse attendeesRegistrationResponse = attendeeService.register(attendeesRegistrationRequest);
        assertThat(attendeesRegistrationResponse).isNotNull();
    }

    private static AttendeesRegistrationRequest attendeesRequestPayLoad() {
        AttendeesRegistrationRequest attendeesRegistrationRequest = new AttendeesRegistrationRequest();
        attendeesRegistrationRequest.setFirstName("Paul");
        attendeesRegistrationRequest.setLastName("Mfon");
        attendeesRegistrationRequest.setEmail("paul1l@gmail.com");
        attendeesRegistrationRequest.setPhoneNumber("08123115688");
        attendeesRegistrationRequest.setOccupation("Software engineer");
        attendeesRegistrationRequest.setLocation("Lagos, Nigeria");
        return attendeesRegistrationRequest;
    }



//    @Test
//    public void testThatIfAttendeesRegisterWithWrongEmail_throwInvalidExceptions(){
//        AttendeesRegistrationRequest attendeesRegistrationRequest = new AttendeesRegistrationRequest();
//        attendeesRegistrationRequest.setEmail("vanessae@gmail.com");
//        attendeesRegistrationRequest.setFirstName("Vanessa");
//        attendeesRegistrationRequest.setLastName("Ben");
//        attendeesRegistrationRequest.setPhoneNumber("090");
//        attendeesRegistrationRequest.setOccupation("Accountant");
//        when(attendeesRepository.findByEmail(anyString())).thenReturn(false);
//        assertThrows(InvalidCredentialException.class,
//                ()-> attendeeService.register(attendeesRegistrationRequest));
//
//    }
}
