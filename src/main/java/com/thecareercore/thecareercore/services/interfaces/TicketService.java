package com.thecareercore.thecareercore.services.interfaces;

import com.thecareercore.thecareercore.dtos.requests.CancelTicketPurchaseRequest;
import com.thecareercore.thecareercore.dtos.requests.PurchaseTicketRequest;
import com.thecareercore.thecareercore.dtos.responses.CancelTicketPurchaseResponse;
import com.thecareercore.thecareercore.dtos.responses.PurchaseTicketResponse;
import com.thecareercore.thecareercore.exceptions.InvalidTicketQuantityException;

public interface TicketService {
    PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest) throws InvalidTicketQuantityException;

    CancelTicketPurchaseResponse cancelTicketPurchase(CancelTicketPurchaseRequest cancelTicketRequest);

}
