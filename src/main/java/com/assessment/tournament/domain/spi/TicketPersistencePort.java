package com.assessment.tournament.domain.spi;

import com.assessment.tournament.domain.model.Ticket;

public interface TicketPersistencePort {
    Ticket save(Ticket ticket);
}
