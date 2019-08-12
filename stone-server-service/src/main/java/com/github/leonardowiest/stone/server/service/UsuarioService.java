package com.github.leonardowiest.stone.server.service;

import com.github.leonardowiest.stone.server.domain.Usuario;

@FunctionalInterface
public interface UsuarioService {

    public abstract Usuario findByLogin(String login);

}
