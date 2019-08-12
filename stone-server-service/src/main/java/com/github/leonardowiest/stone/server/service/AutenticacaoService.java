package com.github.leonardowiest.stone.server.service;

import com.github.leonardowiest.stone.server.dto.AutenticacaoDTO;
import com.github.leonardowiest.stone.server.dto.RetornoAutenticacaoDTO;

@FunctionalInterface
public interface AutenticacaoService {

    public abstract RetornoAutenticacaoDTO realizarLogin(AutenticacaoDTO autenticacaoDTO);

}
