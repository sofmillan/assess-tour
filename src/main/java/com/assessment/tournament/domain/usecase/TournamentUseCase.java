package com.assessment.tournament.domain.usecase;

import com.assessment.tournament.domain.api.TournamentServicePort;
import com.assessment.tournament.domain.model.Tournament;
import com.assessment.tournament.domain.spi.TournamentPersistencePort;
import com.assessment.tournament.infrastructure.output.jpa.entity.TournamentEntity;

public class TournamentUseCase implements TournamentServicePort {

    private final TournamentPersistencePort tournamentPersistencePort;

    public TournamentUseCase(TournamentPersistencePort tournamentPersistencePort) {
        this.tournamentPersistencePort = tournamentPersistencePort;
    }

    @Override
    public Tournament save(Tournament tournament) {
        if(tournamentPersistencePort.getByUserId(tournament.getUserId()).stream().filter(Tournament::getFree).count()<=2){
            throw new RuntimeException("Cannot create more free tournaments");
        }

        tournament.setRemainingCapacity(tournament.getCategory().getCapacity());
        return tournamentPersistencePort.save(tournament);
    }

    @Override
    public Tournament findById(Long id) {
        return null;
    }
}
