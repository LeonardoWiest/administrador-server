package com.github.leonardowiest.wboss.server.service;

import com.github.leonardowiest.wboss.server.dto.AutenticacaoDTO;
import com.github.leonardowiest.wboss.server.dto.RetornoAutenticacaoDTO;

@FunctionalInterface
public interface AutenticacaoService {

	public abstract RetornoAutenticacaoDTO realizarLogin(AutenticacaoDTO autenticacaoDTO);

}
