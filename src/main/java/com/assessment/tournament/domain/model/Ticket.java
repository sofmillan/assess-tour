package com.assessment.tournament.domain.model;

import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private String userId;
    private Tournament tournament;
    private Double totalPrice;
    private LocalDateTime purchaseDate;
    private String code;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Ticket(Long id, String userId, Tournament tournament, Double totalPrice, LocalDateTime purchaseDate, String code) {
        this.id = id;
        this.userId = userId;
        this.tournament = tournament;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
        this.code = code;
    }
}

