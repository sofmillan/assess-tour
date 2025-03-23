package com.assessment.tournament.infrastructure.input.rest;

import com.assessment.tournament.application.dto.TicketRequestDto;
import com.assessment.tournament.application.dto.TournamentRequestDto;
import com.assessment.tournament.application.handler.TicketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketHandler ticketHandler;
    @PostMapping("")
    public void save(@RequestBody TicketRequestDto ticketRequestDto, @RequestHeader(name = "Authorization") String token){
        ticketHandler.save(ticketRequestDto, token);
    }
}
