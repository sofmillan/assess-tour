package com.assessment.tournament.application.handler;

import com.assessment.tournament.application.dto.TournamentRequestDto;
import com.assessment.tournament.application.mapper.TournamentDtoMapper;
import com.assessment.tournament.domain.api.CategoryServicePort;
import com.assessment.tournament.domain.api.IdentityResolver;
import com.assessment.tournament.domain.api.TournamentServicePort;
import com.assessment.tournament.domain.model.Category;
import com.assessment.tournament.domain.model.Tournament;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TournamentHandlerImpl implements TournamentHandler{
    private final CategoryServicePort categoryServicePort;
    private final TournamentServicePort tournamentServicePort;
    private final TournamentDtoMapper tournamentDtoMapper;
    private final IdentityResolver identityResolver;
    @Override
    public void saveTournament(TournamentRequestDto tournamentRequestDto, String token) {
        String userId = identityResolver.getUserIdFromToken(token);
        Category category = categoryServicePort.findById(tournamentRequestDto.getCategoryId());
        Tournament tournament = tournamentDtoMapper.toModel(tournamentRequestDto);
        tournament.setCategory(category);
        tournament.setUserId(userId);
        tournamentServicePort.save(tournament);
    }
}
