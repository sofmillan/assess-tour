package com.assessment.tournament.infrastructure.output.jpa.repository;

import com.assessment.tournament.infrastructure.output.jpa.entity.TournamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepository extends JpaRepository<TournamentEntity, Long> {
    List<TournamentEntity> findByUserId(String userId);
}
