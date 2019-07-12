package com.github.leonardowiest.administrador.server.api;

import static com.github.leonardowiest.administrador.server.util.constants.RequestConstants.PATH_AUTENTICACAO_CONTROLLER;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.leonardowiest.administrador.server.dto.RetornoAutenticacaoDTO;

@RequestMapping(value = PATH_AUTENTICACAO_CONTROLLER, consumes = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public interface AutenticacaoController {

	public abstract RetornoAutenticacaoDTO realizarLogin();

}
