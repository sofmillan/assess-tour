package com.assessment.tournament.infrastructure.security;

import com.assessment.tournament.domain.api.IdentityResolver;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class JwtClaimsResolver implements IdentityResolver {
    public String getUserIdFromToken(String token)  {

        // Parse the JWT using parserBuilder()
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser()
                    .verifyWith(getPublicKeyFromJson())
                    .build()
                    .parseSignedClaims(token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return claims.getPayload().get("sub").toString();
    }

    private static PublicKey getPublicKeyFromJson() throws Exception {
        // Parse the JSON
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree("""
                    {
                      "e": "AQAB",
                      "kty": "RSA",
                      "n": "w9i-KcrtrSacO40OxCGd_SfZndSqUJGcQ5Qo09ToPUYsWavPvgOzAzOncmOI1DXoZlHavB0AARtsFt8GCgR8FZM3zk11ZrrXtYtBc0K6ewR1TjdxTfjICk0tlNy1_tbOXIbYO653I5w9dyUlbI_0-IDbSKAnKuzCXXgwbc5oTW0BEcO4Uq8G9FE_6Y9JddHbt4xIfWIXRXODpWqfRbsmHKdGTZHe5-MJOGGr3XOS-0MDmHAFIAFI5Icw5Tgq4oYyB4Id4PgVB4ulKi-ZQSnf8EW7o1gzpEjADKZbTRQFEK8M3OyxcTc1JM-WOdyUz4iXc_ofOrIGiv1b3A3jg8-dyw"
                    }
                """);

        // Extract "n" (modulus) and "e" (exponent)
        String n = jsonNode.get("n").asText();
        String e = jsonNode.get("e").asText();

        // Decode Base64 URL-safe encoding
        BigInteger modulus = new BigInteger(1, Base64.getUrlDecoder().decode(n));
        BigInteger exponent = new BigInteger(1, Base64.getUrlDecoder().decode(e));

        // Create the RSA PublicKey
        RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(modulus, exponent);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(publicKeySpec);
    }
}
