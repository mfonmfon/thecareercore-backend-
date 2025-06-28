package com.thecareercore.thecareercore;

import com.thecareercore.thecareercore.dtos.requests.AttendeesRegistrationRequest;
import com.thecareercore.thecareercore.dtos.responses.AttendeesRegistrationResponse;
import com.thecareercore.thecareercore.exceptions.AttendeesNotFoundException;
import com.thecareercore.thecareercore.services.interfaces.AttendeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AttendeeServiceTest {

    @Autowired
    private AttendeeService attendeeService;


    @Test
    public void testThatAttendeesCanRegisterForTheEvent(){
        AttendeesRegistrationRequest attendeesRegistrationRequest = new AttendeesRegistrationRequest();
        attendeesRegistrationRequest.setFirstName("Paul");
        attendeesRegistrationRequest.setLastName("Mfon");
        attendeesRegistrationRequest.setEmail("paul@gmail.com");
        attendeesRegistrationRequest.setPhoneNumber("08123115688");
        attendeesRegistrationRequest.setOccupation("Software engineer");
        AttendeesRegistrationResponse attendeesRegistrationResponse = attendeeService.register(attendeesRegistrationRequest);
        assertThat(attendeesRegistrationResponse).isNotNull();
    }
}
