package com.thecareercore.thecareercore.utils;

import com.thecareercore.thecareercore.exceptions.InvalidFieldsException;

public class Mapper {

    public void validateAttendeesInputs(String firstName, String lastName, String email,String location, String occupation, String phoneNumber) {
        if (firstName == null || firstName.isEmpty())throw new InvalidFieldsException("First Name is required");
        if (lastName == null || lastName.trim().isEmpty())throw new InvalidFieldsException("Last name is required");
        if (email == null || email.trim().isEmpty())throw new InvalidFieldsException("Email is required");
        if (location == null || location.trim().isEmpty())throw new InvalidFieldsException("Location is required");
        if (occupation == null || occupation.trim().isEmpty())throw new InvalidFieldsException("Occupation is required");
        if (phoneNumber == null|| phoneNumber.trim().isEmpty())throw new InvalidFieldsException("Phone number is required");
        if (!firstName.matches("^[A-Za-z\\s'-]{2,50}$"))
            throw new InvalidFieldsException("First name must contain only letters, spaces, hyphens, or apostrophes");

        if (!lastName.matches("^[A-Za-z\\s'-]{2,50}$"))
            throw new InvalidFieldsException("Last name must contain only letters, spaces, hyphens, or apostrophes");

        if (!occupation.matches("^[A-Za-z\\s'-]{2,50}$"))
            throw new InvalidFieldsException("Occupation must contain only letters, spaces, hyphens, or apostrophes");

        if (!location.matches("^[A-Za-z\\s',-]{2,100}$"))
            throw new InvalidFieldsException("Location contains invalid characters");

    }


    public void validateSponsorInput(String firstName, String lastName, String companyName, String companyDescription, String companyEmail,
                                     String phoneNumber, String whereYouHeardCareerCore) {
        if (firstName == null|| firstName.trim().isEmpty()) throw new InvalidFieldsException("first name is required");
        if (lastName == null || lastName.trim().isEmpty()) throw new InvalidFieldsException("Last name is required");
        if (companyName == null || companyName.trim().isEmpty()) throw new InvalidFieldsException("Company name is required");
        if (companyDescription == null|| companyDescription.trim().isEmpty()) throw new InvalidFieldsException("Company description is required");
        if (companyEmail == null|| companyEmail.trim().isEmpty()) throw new InvalidFieldsException("Company email is required");

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) throw new InvalidFieldsException("Phone number is required");

        if (whereYouHeardCareerCore == null || whereYouHeardCareerCore.trim().isEmpty()) throw new InvalidFieldsException("This field can not be empty");

        if (!firstName.matches("^[A-Za-z\\s'-]{2,50}$")) throw new InvalidFieldsException("First name must contain only letters, spaces, hyphens, or apostrophes");

        if (!lastName.matches("^[A-Za-z\\s'-]{2,50}$")) throw new InvalidFieldsException("Last name must contain only letters, spaces, hyphens, or apostrophes");

        if (!whereYouHeardCareerCore.matches("^[A-Za-z\\s'-]{2,50}$")) throw new InvalidFieldsException("This field must contain only letters, spaces, hyphens, or apostrophes");

        if (!companyDescription.matches("^[A-Za-z\\s'-]{2,50}$")) throw new InvalidFieldsException("Company description must contain only letters, spaces, hyphens, or apostrophes");

        if (!companyName.matches("^[A-Za-z\\s'-]{2,50}$")) throw new InvalidFieldsException("Company name must contain only letters, spaces, hyphens, or apostrophes");
    }


}
