package com.github.leonardowiest.stone.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.github.leonardowiest.stone.server.domain.Usuario;
import com.github.leonardowiest.stone.server.repository.UsuarioRepository;
import com.github.leonardowiest.stone.server.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Lazy
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

}
