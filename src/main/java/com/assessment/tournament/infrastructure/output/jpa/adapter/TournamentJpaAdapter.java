package com.assessment.tournament.infrastructure.output.jpa.adapter;

import com.assessment.tournament.domain.model.Tournament;
import com.assessment.tournament.domain.spi.TournamentPersistencePort;
import com.assessment.tournament.infrastructure.output.jpa.mapper.TournamentEntityMapper;
import com.assessment.tournament.infrastructure.output.jpa.repository.TournamentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TournamentJpaAdapter implements TournamentPersistencePort {
    private final TournamentRepository tournamentRepository;
    private final TournamentEntityMapper tournamentEntityMapper;
    @Override
    public Tournament save(Tournament tournament) {

        return tournamentEntityMapper.toModel(tournamentRepository.save(tournamentEntityMapper.toEntity(tournament)));
    }

    @Override
    public List<Tournament> getByUserId(String userId) {
        return tournamentRepository.findByUserId(userId).stream().map(tournamentEntityMapper::toModel).toList();
    }
}
