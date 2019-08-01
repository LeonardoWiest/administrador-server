package com.github.leonardowiest.wboss.server.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.leonardowiest.wboss.server.service.UsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Lazy
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return Optional.ofNullable(usuarioService.findByLogin(username)).orElseThrow(() -> new RuntimeException("vazio"));

    }

}
