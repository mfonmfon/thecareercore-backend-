package com.thecareercore.thecareercore;

import com.thecareercore.thecareercore.domain.enums.TicketType;
import com.thecareercore.thecareercore.dtos.requests.PurchaseTicketRequest;
import com.thecareercore.thecareercore.dtos.responses.PurchaseTicketResponse;
import com.thecareercore.thecareercore.exceptions.InvalidTicketQuantityException;
import com.thecareercore.thecareercore.services.interfaces.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Test
    public void testThatCanPurchaseTicket() throws InvalidTicketQuantityException {
        Long attendeeId = 1L;
        Integer quantityTicket = 10;
        PurchaseTicketRequest purchaseTicketRequest = new PurchaseTicketRequest();
        purchaseTicketRequest.setAttendeeID(attendeeId);
        purchaseTicketRequest.setTicketType(TicketType.valueOf(TicketType.GENERAL_ATTENDEES_TICKET_TYPE.toString()));
        purchaseTicketRequest.setBoughtAt(LocalDateTime.now());
        purchaseTicketRequest.setQuantity(quantityTicket);
        PurchaseTicketResponse purchaseTicketResponse = ticketService.purchaseTicket(purchaseTicketRequest);
        assertThat(purchaseTicketResponse).isNotNull();
    }
}
