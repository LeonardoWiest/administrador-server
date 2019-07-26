package com.github.leonardowiest.wboss.server.security;

import com.github.leonardowiest.wboss.server.domain.Usuario;

public interface JwtTokenProviderService {

	public abstract String gerarToken(Usuario usuario);

}
