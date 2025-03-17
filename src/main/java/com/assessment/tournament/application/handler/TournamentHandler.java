package com.assessment.tournament.application.handler;

import com.assessment.tournament.application.dto.TournamentRequestDto;

public interface TournamentHandler {
    void saveTournament(TournamentRequestDto tournamentRequestDto, String token);
}
