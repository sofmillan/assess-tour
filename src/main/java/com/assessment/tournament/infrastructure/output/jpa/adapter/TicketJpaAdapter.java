package com.assessment.tournament.infrastructure.output.jpa.adapter;

import com.assessment.tournament.domain.api.TicketServicePort;
import com.assessment.tournament.domain.model.Ticket;

public class TicketJpaAdapter implements TicketServicePort {
    @Override
    public Ticket save(Ticket ticket) {
        return null;
    }
}
