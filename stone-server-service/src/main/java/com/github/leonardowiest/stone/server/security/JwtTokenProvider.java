package com.github.leonardowiest.stone.server.security;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.github.leonardowiest.stone.server.domain.Usuario;
import com.github.leonardowiest.stone.server.util.constants.GlobalConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    @Value("${wboss.global.secret.key}")
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

    public Boolean validarToken(String token) {

        Jwts.parser().setSigningKey(chaveSecreta.getBytes()).parseClaimsJws(token);

        return Boolean.TRUE;

    }

    public Authentication buscarUsuarioAutenticado(String token) {
        return new UsernamePasswordAuthenticationToken(token, null, null);
    }

}
