package com.assessment.tournament.application.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class TournamentRequestDto {

    private String description;
    private String name;
    private Long categoryId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double ticketPrice;
    private Boolean isFree;

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }
}
