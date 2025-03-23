package com.assessment.tournament.domain.api;

import com.assessment.tournament.domain.model.Tournament;

public interface TournamentServicePort {
    Tournament save(Tournament tournament);
    Tournament findById(Long id);
}
