package com.thecareercore.thecareercore.domain.repository;

import com.thecareercore.thecareercore.domain.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
