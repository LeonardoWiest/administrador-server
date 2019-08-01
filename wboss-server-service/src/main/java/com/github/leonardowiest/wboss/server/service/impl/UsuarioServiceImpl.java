package com.github.leonardowiest.wboss.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.github.leonardowiest.wboss.server.domain.Usuario;
import com.github.leonardowiest.wboss.server.repository.UsuarioRepository;
import com.github.leonardowiest.wboss.server.service.UsuarioService;

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
