package com.github.leonardowiest.wboss.server.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.github.leonardowiest.wboss.server.util.constants.GlobalConstants;

import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtTokenFilter extends GenericFilterBean {

    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;

        String token = jwtTokenProvider.resolverHeaderToken((HttpServletRequest) req);

        if (token != null && !token.contains(GlobalConstants.JWT_BASIC)) {

            try {

                jwtTokenProvider.validarToken(token);

            } catch (JwtException | IllegalArgumentException e) {

                log.warn("Token inválido");

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().flush();
                response.getWriter().close();

                return;
            }

            SecurityContextHolder.getContext().setAuthentication(jwtTokenProvider.buscarUsuarioAutenticado(token));

        }

        filterChain.doFilter(req, response);

    }

}
