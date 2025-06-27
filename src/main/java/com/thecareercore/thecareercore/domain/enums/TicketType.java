package com.thecareercore.thecareercore.domain.enums;

public enum TicketType {

    GENERAL_ATTENDEES_TICKET_TYPE("10,000"),
    STUDENT_ATTENDEES_TICKET_TYPE("5000");

    private final String ticketTypeAndPrice;

    TicketType(String ticketTypeAndPrice){
        this.ticketTypeAndPrice = ticketTypeAndPrice;
    }
    private String getTicketTypeAndPrice(){
        return ticketTypeAndPrice;
    }
}
