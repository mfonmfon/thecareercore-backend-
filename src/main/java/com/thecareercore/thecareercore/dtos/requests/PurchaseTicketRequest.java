package com.thecareercore.thecareercore.dtos.requests;

import com.thecareercore.thecareercore.domain.enums.TicketType;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;


public class PurchaseTicketRequest {


    private Long attendeeID;
    private Integer quantity;
    private TicketType ticketType;
//    private LocalDateTime boughtAt;


    public Long getAttendeeID() {
        return attendeeID;
    }

    public void setAttendeeID(Long attendeeID) {
        this.attendeeID = attendeeID;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}
