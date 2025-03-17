package com.assessment.tournament.domain.api;

public interface IdentityResolver {
    String getUserIdFromToken(String token);
}
