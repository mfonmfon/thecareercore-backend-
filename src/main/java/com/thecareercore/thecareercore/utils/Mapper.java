package com.thecareercore.thecareercore.utils;

import com.thecareercore.thecareercore.exceptions.InvalidFieldsException;

public class Mapper {

    public void validateAttendeesInputs(String firstName, String lastName, String email, String occupation, String phoneNumber) {
        if (firstName.isEmpty())throw new InvalidFieldsException("First Name is required");
        if (lastName.trim().isEmpty())throw new InvalidFieldsException("Last name is required");
        if (email.trim().isEmpty())throw new InvalidFieldsException("Email is required");
        if (occupation.trim().isEmpty())throw new InvalidFieldsException("Occupation is required");
        if (phoneNumber.trim().isEmpty())throw new InvalidFieldsException("Phone number is required");
    }


}
