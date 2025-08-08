package com.thecareercore.thecareercore.dtos.requests;

public class BecomeASponsorRequest {
    private String firstName;
    private String lastName;
    private String companyEmail;
    private String companyName;
    private String phoneNumber;
    private String whereYouHeardCareerCore;
    private String companyDescription;

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWhereYouHeardCareerCore() {
        return whereYouHeardCareerCore;
    }

    public void setWhereYouHeardCareerCore(String whereYouHeardCareerCore) {
        this.whereYouHeardCareerCore = whereYouHeardCareerCore;
    }
}
