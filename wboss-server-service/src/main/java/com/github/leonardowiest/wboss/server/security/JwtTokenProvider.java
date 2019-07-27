package com.github.leonardowiest.wboss.server.security;

import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.JWT_BEARER;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.JWT_VALIDITY_MILLISECONDS;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.UNIVERSAL_SECRET_KEY;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

		Date dataAtual = new Date();

		Date dataExpiracao = new Date(dataAtual.getTime() + JWT_VALIDITY_MILLISECONDS);

		return Jwts.builder().setClaims(claims).setIssuedAt(dataAtual).setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, UNIVERSAL_SECRET_KEY).compact();
	}

	public String converterToken(String bearerToken) {

		if (bearerToken.startsWith(JWT_BEARER)) {
			return bearerToken.substring(7, bearerToken.length());
		}

		return bearerToken;

	}

	public Boolean validarToken(String token) {

		Jwts.parser().setSigningKey(UNIVERSAL_SECRET_KEY.getBytes()).parseClaimsJws(token);

		return Boolean.TRUE;

	}

	public Authentication getAuthentication(String token) {

		return new UsernamePasswordAuthenticationToken(token, null, null);

	}

	public String getPayloadByToken(String token) {

		return Jwts.parser().setSigningKey(UNIVERSAL_SECRET_KEY.getBytes()).parseClaimsJws(converterToken(token))
				.getBody().getSubject();

	}

}
