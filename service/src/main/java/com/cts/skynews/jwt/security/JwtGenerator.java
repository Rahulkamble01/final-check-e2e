package com.cts.skynews.jwt.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cts.skynews.bean.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtGenerator.class);

	public String generate(User user) {
		LOGGER.info("Start : JwtGenerator");

		Claims claims = Jwts.claims().setSubject(user.getName());
		claims.put("userId", String.valueOf(user.getId()));
		claims.put("role", user.getRole().getDescription());
		LOGGER.info("END : JwtGenerator");
		return (Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "skynews").compact());
		
	}
}
