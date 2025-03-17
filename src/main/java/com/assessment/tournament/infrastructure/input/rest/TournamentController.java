package com.assessment.tournament.infrastructure.input.rest;

import com.assessment.tournament.application.dto.TournamentRequestDto;
import com.assessment.tournament.application.handler.TournamentHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

@RestController
@RequestMapping("/tournament")
@RequiredArgsConstructor
public class TournamentController {

    private final TournamentHandler tournamentHandler;

    @PostMapping("")
    public void save(@RequestBody TournamentRequestDto tournamentRequestDto, @RequestHeader(name = "Authorization") String token){
        tournamentHandler.saveTournament(tournamentRequestDto, token);
    }




}
