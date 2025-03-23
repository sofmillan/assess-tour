package com.assessment.tournament.domain.api;

import com.assessment.tournament.domain.model.Ticket;

public interface TicketServicePort {
    Ticket save(Ticket ticket);
}
