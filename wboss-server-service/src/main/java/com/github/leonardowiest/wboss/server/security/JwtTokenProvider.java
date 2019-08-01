package com.github.leonardowiest.wboss.server.security;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.leonardowiest.wboss.server.domain.Usuario;
import com.github.leonardowiest.wboss.server.util.constants.GlobalConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    @Value("${wboss.jwt.secret.key}")
    private String chaveSecreta;

    @Value("${wboss.jwt.expiracao}")
    private Long tempoExpiracao;

    @PostConstruct
    protected void init() {
        chaveSecreta = Base64.getEncoder().encodeToString(chaveSecreta.getBytes());
    }

    public String gerarToken(Usuario usuario) {

        Date dataGeracaoToken = new Date();

        Date dataExpiracaoToken = new Date(dataGeracaoToken.getTime() + tempoExpiracao);

        return Jwts.builder().setIssuer(usuario.getLogin()).setSubject(usuario.getId().toString()).setIssuedAt(dataGeracaoToken)
                .setExpiration(dataExpiracaoToken).signWith(SignatureAlgorithm.HS256, chaveSecreta).compact();

    }

    public String resolverHeaderToken(HttpServletRequest req) {
        return converterToken(req.getHeader(GlobalConstants.AUTHORIZATION));
    }

    private String converterToken(String bearerToken) {

        if (bearerToken == null) {
            return null;
        }

        if (bearerToken.startsWith(GlobalConstants.JWT_BEARER)) {
            return bearerToken.substring(7, bearerToken.length());
        }

        return bearerToken;
    }

}
