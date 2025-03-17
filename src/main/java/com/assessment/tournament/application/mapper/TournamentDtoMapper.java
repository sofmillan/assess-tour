package com.assessment.tournament.application.mapper;

import com.assessment.tournament.application.dto.TournamentRequestDto;
import com.assessment.tournament.domain.model.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface TournamentDtoMapper {
    Tournament toModel(TournamentRequestDto tournamentRequestDto);
}
