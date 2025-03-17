package com.assessment.tournament.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tournament")
@Data
public class TournamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    private LocalDate startDate;
    private LocalDate endDate;
    private String userId;
    private Double ticketPrice;
    private Integer remainingCapacity;
    private Boolean isFree;

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }
}
