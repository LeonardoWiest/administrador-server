package com.github.leonardowiest.wboss.server.security;

import com.github.leonardowiest.wboss.server.domain.Usuario;

public interface JwtTokenProvider {

	public abstract String gerarToken(Usuario usuario);

}
