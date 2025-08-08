package com.thecareercore.thecareercore.services.implimentation;

import com.thecareercore.thecareercore.domain.enums.TicketType;
import com.thecareercore.thecareercore.domain.model.Attendees;
import com.thecareercore.thecareercore.domain.model.Ticket;
import com.thecareercore.thecareercore.domain.repository.AttendeesRepository;
import com.thecareercore.thecareercore.domain.repository.TicketRepository;
import com.thecareercore.thecareercore.dtos.requests.CancelTicketPurchaseRequest;
import com.thecareercore.thecareercore.dtos.requests.PurchaseTicketRequest;
import com.thecareercore.thecareercore.dtos.responses.CancelTicketPurchaseResponse;
import com.thecareercore.thecareercore.dtos.responses.PurchaseTicketResponse;
import com.thecareercore.thecareercore.exceptions.*;
import com.thecareercore.thecareercore.services.interfaces.TicketService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.thecareercore.thecareercore.dtos.responses.AppResponse.*;

@Service
public class TicketServiceImpl implements TicketService {
    private final AttendeesRepository attendeesRepository;
    private final TicketRepository ticketRepository;
    private static final Integer MAX_TICKET_QUANTITY = 10;
    private static final LocalDateTime THE_CAREER_CORE_END_EVENT_DATE = LocalDateTime.of(2025,9,15,23,59);

    public TicketServiceImpl(AttendeesRepository attendeesRepository, TicketRepository ticketRepository) {
        this.attendeesRepository = attendeesRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest) throws InvalidTicketQuantityException {
        Attendees attendees = attendeesRepository.findById(purchaseTicketRequest.getAttendeeID())
                .orElseThrow(()-> new AttendeesNotFoundException(ATTENDEES_NOT_FOUND_EXCEPTION.getMessage()));
        validateTicketPurchaseInput(purchaseTicketRequest.getTicketType(),
                purchaseTicketRequest.getQuantity());
        Integer quantity = purchaseTicketRequest.getQuantity();
        LocalDateTime now = LocalDateTime.now();
        validateExactDateTime(now);
        validateTicketPurchaseMaxAndInvalidDate(purchaseTicketRequest, quantity);
        Ticket ticket = buildTicketCreation(purchaseTicketRequest, attendees, now);
        ticketRepository.save(ticket);
        PurchaseTicketResponse purchaseTicketResponse = new PurchaseTicketResponse();
        purchaseTicketResponse.setStatusCode(TICKET_PURCHASE_SUCCESS_MESSAGE.getMessage());
        return purchaseTicketResponse;
    }
    @Override
    public CancelTicketPurchaseResponse cancelTicketPurchase(CancelTicketPurchaseRequest cancelTicketRequest) {
        Ticket ticket = ticketRepository.findById(cancelTicketRequest.getTicketId()).
                orElseThrow(()-> new TicketNotFoundException(
                        String.format(
                                TICKET_NOT_FOUND_EXCEPTION.getMessage())));
        ticket.setId(cancelTicketRequest.getTicketId());
        ticketRepository.delete(ticket);
        CancelTicketPurchaseResponse cancelTicketPurchaseResponse = new CancelTicketPurchaseResponse();
        cancelTicketPurchaseResponse.setMessage(CANCEL_TICKET_PURCHASE_EXCEPTION.getMessage());
        return cancelTicketPurchaseResponse;
    }
    private static void validateExactDateTime(LocalDateTime now) {
        if (now.isAfter(THE_CAREER_CORE_END_EVENT_DATE)){
            throw new InvalidTicketPurchase("Cannot purchase ticket after the event has ended");
        }
    }
    private static Ticket buildTicketCreation(PurchaseTicketRequest purchaseTicketRequest, Attendees attendees, LocalDateTime now) {
        Ticket ticket = new Ticket();
        ticket.setAttendees(attendees);
        ticket.setTicketType(purchaseTicketRequest.getTicketType());
        ticket.setQuantity(purchaseTicketRequest.getQuantity());
        ticket.setCreatedAt(now);
        ticket.setPaid(false);
        return ticket;
    }

    private void validateTicketPurchaseMaxAndInvalidDate(PurchaseTicketRequest purchaseTicketRequest, Integer quantity) throws InvalidTicketQuantityException {
        if (quantity > MAX_TICKET_QUANTITY){
            throw new InvalidTicketQuantityException(
                    String.format("Ticket quantity can not exceed limit: %d", MAX_TICKET_QUANTITY)
            );
        }
    }
    private static void validateTicketPurchaseInput(TicketType ticketType, Integer quantity) throws InvalidTicketQuantityException {
        if (quantity == null || quantity <= 0)throw new InvalidTicketQuantityException(INVALID_TICKET_QUANTITY.getMessage());
        if (ticketType == null)throw new InvalidFieldsException("This fields required ");
    }
}
