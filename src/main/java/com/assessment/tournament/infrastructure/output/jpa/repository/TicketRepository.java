package com.assessment.tournament.infrastructure.output.jpa.repository;

import com.assessment.tournament.infrastructure.output.jpa.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
