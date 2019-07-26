package com.github.leonardowiest.wboss.server.service;

import com.github.leonardowiest.wboss.server.domain.Usuario;

@FunctionalInterface
public interface UsuarioService {

	public abstract Usuario findByLogin(String login);

}
