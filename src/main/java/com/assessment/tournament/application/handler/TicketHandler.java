package com.assessment.tournament.application.handler;

import com.assessment.tournament.application.dto.TicketRequestDto;

public interface TicketHandler {
    void save(TicketRequestDto ticketRequestDto, String token);
}
