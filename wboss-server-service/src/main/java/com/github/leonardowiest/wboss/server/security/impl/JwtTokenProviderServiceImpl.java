package com.github.leonardowiest.wboss.server.security.impl;

import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.JWT_VALIDITY_MILLISECONDS;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.UNIVERSAL_SECRET_KEY;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.github.leonardowiest.wboss.server.domain.Usuario;
import com.github.leonardowiest.wboss.server.security.JwtTokenProviderService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenProviderServiceImpl implements JwtTokenProviderService {

	@PostConstruct
	protected void init() {
		UNIVERSAL_SECRET_KEY = Base64.getEncoder().encodeToString(UNIVERSAL_SECRET_KEY.getBytes());
	}

	@Override
	public String gerarToken(Usuario usuario) {

		Claims claims = Jwts.claims().setSubject(usuario.getLogin());

		Date dateNow = new Date();

		Date dateValidity = new Date(dateNow.getTime() + JWT_VALIDITY_MILLISECONDS);

		return Jwts.builder().setClaims(claims).setIssuedAt(dateNow).setExpiration(dateValidity)
				.signWith(SignatureAlgorithm.HS256, UNIVERSAL_SECRET_KEY).compact();
	}

}
