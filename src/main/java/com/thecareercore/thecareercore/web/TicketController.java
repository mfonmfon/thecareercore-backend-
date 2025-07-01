package com.thecareercore.thecareercore.web;

import com.thecareercore.thecareercore.dtos.requests.PurchaseTicketRequest;
import com.thecareercore.thecareercore.dtos.responses.ApiResponse;
import com.thecareercore.thecareercore.dtos.responses.PurchaseTicketResponse;
import com.thecareercore.thecareercore.services.interfaces.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket/")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<?> purchaseTicket(@RequestBody PurchaseTicketRequest purchaseTicketRequest){
        try {
            PurchaseTicketResponse purchaseTicketResponse = ticketService.purchaseTicket(purchaseTicketRequest);
            return new ResponseEntity<>((new ApiResponse(true, purchaseTicketResponse)), HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>((new ApiResponse(false, exception.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }
}
