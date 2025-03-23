package com.assessment.tournament.infrastructure.output.jpa.entity;

import com.assessment.tournament.domain.model.Tournament;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private TournamentEntity tournament;
    private Double totalPrice;
    private LocalDateTime purchaseDate;
    private String code;
}
