package com.github.leonardowiest.wboss.server.security;

import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.JWT_VALIDITY_MILLISECONDS;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.UNIVERSAL_SECRET_KEY;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.github.leonardowiest.wboss.server.domain.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

	@PostConstruct
	protected void init() {
		UNIVERSAL_SECRET_KEY = Base64.getEncoder().encodeToString(UNIVERSAL_SECRET_KEY.getBytes());
	}

	public String gerarToken(Usuario usuario) {

		Claims claims = Jwts.claims().setSubject(usuario.getLogin());

		Date dateNow = new Date();

		Date dateValidity = new Date(dateNow.getTime() + JWT_VALIDITY_MILLISECONDS);

		return Jwts.builder().setClaims(claims).setIssuedAt(dateNow).setExpiration(dateValidity)
				.signWith(SignatureAlgorithm.HS256, UNIVERSAL_SECRET_KEY).compact();
	}

}
