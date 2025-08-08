package com.thecareercore.thecareercore.web;

import com.thecareercore.thecareercore.dtos.requests.AttendeesRegistrationRequest;
import com.thecareercore.thecareercore.dtos.requests.BecomeASponsorRequest;
import com.thecareercore.thecareercore.dtos.responses.ApiResponse;
import com.thecareercore.thecareercore.dtos.responses.AttendeesRegistrationResponse;
import com.thecareercore.thecareercore.dtos.responses.BecomeASponsorResponse;
import com.thecareercore.thecareercore.services.interfaces.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeesController {

    private final AttendeeService attendeeService;

    public AttendeesController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AttendeesRegistrationRequest attendeesRegistrationRequest){
        try {
            AttendeesRegistrationResponse attendeesRegistrationResponse = attendeeService.register(attendeesRegistrationRequest);
            return new ResponseEntity<>((new ApiResponse(true, attendeesRegistrationResponse)), HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>((new ApiResponse(false, exception.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }


}