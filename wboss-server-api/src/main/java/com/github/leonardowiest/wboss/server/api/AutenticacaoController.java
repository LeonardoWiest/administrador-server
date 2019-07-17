package com.github.leonardowiest.wboss.server.api;

import static com.github.leonardowiest.wboss.server.util.constants.HttpResponseStatusConstants.PROTOCOL_HTTP;
import static com.github.leonardowiest.wboss.server.util.constants.RequestConstants.API_REALIZAR_LOGIN;
import static com.github.leonardowiest.wboss.server.util.constants.RequestConstants.AUTENTICACAO_CONTROLLER;
import static com.github.leonardowiest.wboss.server.util.constants.RequestConstants.REALIZAR_LOGIN;
import static com.github.leonardowiest.wboss.server.util.constants.RequestConstants.TAG_AUTENTICACAO;

import org.springframework.web.bind.annotation.PostMapping;

import com.github.leonardowiest.wboss.server.dto.RetornoAutenticacaoDTO;
import com.github.leonardowiest.wboss.server.util.annotations.WBossResponses;
import com.github.leonardowiest.wboss.server.util.annotations.WbossRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { TAG_AUTENTICACAO }, protocols = PROTOCOL_HTTP)
@WbossRequest(AUTENTICACAO_CONTROLLER)
public interface AutenticacaoController {

	@WBossResponses
	@ApiOperation(value = API_REALIZAR_LOGIN, response = RetornoAutenticacaoDTO.class)
	@PostMapping(REALIZAR_LOGIN)
	public abstract RetornoAutenticacaoDTO realizarLogin();

}
