package com.pccomponentes.practice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JWT {

    private static final String signKey = "zongzhen";

    private static final Long expire = 600000L;

    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
    }

    public static Claims parseJwt(String jwt) {
        return Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

}
