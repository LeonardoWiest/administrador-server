package com.github.leonardowiest.stone.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.github.leonardowiest.stone.server.dto.AutenticacaoDTO;
import com.github.leonardowiest.stone.server.dto.RetornoAutenticacaoDTO;
import com.github.leonardowiest.stone.server.resources.ResourceException;
import com.github.leonardowiest.stone.server.security.JwtTokenProvider;
import com.github.leonardowiest.stone.server.service.AutenticacaoService;
import com.github.leonardowiest.wboss.server.repository.UsuarioRepository;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

    @Lazy
    @Autowired
    AuthenticationManager authenticationManager;

    @Lazy
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Override
    public RetornoAutenticacaoDTO realizarLogin(AutenticacaoDTO autenticacaoDTO) {

        if (autenticacaoDTO.getLogin().equals("wiest")) {
            throw ResourceException.getException("PROPRIEDADE");
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(autenticacaoDTO.getLogin(),
                autenticacaoDTO.getSenha());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        return buscarToken(autenticacaoDTO.getLogin());
    }

    private RetornoAutenticacaoDTO buscarToken(String login) {
        return new RetornoAutenticacaoDTO(jwtTokenProvider.gerarToken(usuarioRepository.findByLogin(login)));
    }

}
