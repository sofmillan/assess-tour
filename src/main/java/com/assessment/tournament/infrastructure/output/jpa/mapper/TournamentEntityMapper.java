package com.assessment.tournament.infrastructure.output.jpa.mapper;

import com.assessment.tournament.domain.model.Tournament;
import com.assessment.tournament.infrastructure.output.jpa.entity.TournamentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface TournamentEntityMapper {
    TournamentEntity toEntity(Tournament tournament);
    Tournament toModel(TournamentEntity tournament);
}
