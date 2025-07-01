package com.thecareercore.thecareercore.dtos.responses;

public enum AppResponse {

    INVALID_TICKET_QUANTITY("Invalid quantity"),
    TICKET_PURCHASE_SUCCESS_MESSAGE("SUCCESS"),
    ATTENDEES_NOT_FOUND_EXCEPTION("Attendee not found"),
    ATTENDEES_REGISTRATION_SUCCESS_MESSAGE("SUCCESS"),
    ATTENDEES_ALREADY_EXIST_EXCEPTION("Email Already exist");
//    INVALID_CREDENTIALS_EXCEPTION("Invalid credentials");


    private final String message;

    AppResponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
