package com.github.leonardowiest.wboss.server.security;

import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.AUTHORIZATION;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.JWT_BASIC;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.JwtException;

public class JwtTokenFilter extends GenericFilterBean {

	private JwtTokenProvider jwtTokenProvider;

	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String token = jwtTokenProvider.converterToken(httpResponse.getHeader(AUTHORIZATION));

		if (token != null && token.contains(JWT_BASIC)) {

			try {
				jwtTokenProvider.validarToken(token);
			} catch (JwtException | IllegalArgumentException e) {

				httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				httpResponse.getWriter().flush();
				httpResponse.getWriter().close();

				return;

			}

		}

		SecurityContextHolder.getContext().setAuthentication(jwtTokenProvider.getAuthentication(token));

	}

}
