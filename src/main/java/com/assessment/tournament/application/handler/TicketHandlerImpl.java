package com.assessment.tournament.application.handler;

import com.assessment.tournament.application.dto.TicketRequestDto;
import com.assessment.tournament.domain.api.IdentityResolver;
import com.assessment.tournament.domain.api.TicketServicePort;
import com.assessment.tournament.domain.api.TournamentServicePort;
import com.assessment.tournament.domain.model.Ticket;
import com.assessment.tournament.domain.model.Tournament;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketHandlerImpl implements TicketHandler{
    private final TournamentServicePort tournamentServicePort;
    private final TicketServicePort ticketServicePort;
    private final IdentityResolver identityResolver;

    @Override
    public void save(TicketRequestDto ticketRequestDto, String token) {
        String userId = identityResolver.getUserIdFromToken(token);
        Tournament tournament = tournamentServicePort.findById(ticketRequestDto.getTournamentId());
        Ticket ticket = new Ticket();
        ticket.setUserId(userId);
        ticket.setTournament(tournament);
        ticketServicePort.save(ticket);
    }
}
