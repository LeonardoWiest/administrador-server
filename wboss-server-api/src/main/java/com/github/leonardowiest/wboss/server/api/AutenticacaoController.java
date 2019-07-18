package com.github.leonardowiest.wboss.server.api;

import static com.github.leonardowiest.wboss.server.util.constants.HttpResponseStatusConstants.PROTOCOL_HTTP;
import static com.github.leonardowiest.wboss.server.util.constants.HttpResponseStatusConstants.STATUS_CODE_200;
import static com.github.leonardowiest.wboss.server.util.constants.HttpResponseStatusConstants.STATUS_CODE_204;
import static com.github.leonardowiest.wboss.server.util.constants.HttpResponseStatusConstants.STATUS_CODE_400;
import static com.github.leonardowiest.wboss.server.util.constants.HttpResponseStatusConstants.STATUS_CODE_401;
import static com.github.leonardowiest.wboss.server.util.constants.HttpResponseStatusConstants.STATUS_CODE_403;
import static com.github.leonardowiest.wboss.server.util.constants.HttpResponseStatusConstants.STATUS_CODE_404;
import static com.github.leonardowiest.wboss.server.util.constants.HttpResponseStatusConstants.STATUS_CODE_500;
import static com.github.leonardowiest.wboss.server.util.constants.RequestConstants.API_REALIZAR_LOGIN;
import static com.github.leonardowiest.wboss.server.util.constants.RequestConstants.AUTENTICACAO_CONTROLLER;
import static com.github.leonardowiest.wboss.server.util.constants.RequestConstants.REALIZAR_LOGIN;
import static com.github.leonardowiest.wboss.server.util.constants.RequestConstants.TAG_AUTENTICACAO;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.leonardowiest.wboss.server.dto.AutenticacaoDTO;
import com.github.leonardowiest.wboss.server.dto.RetornoAutenticacaoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { TAG_AUTENTICACAO }, protocols = PROTOCOL_HTTP)
@RequestMapping(value = AUTENTICACAO_CONTROLLER, consumes = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public interface AutenticacaoController {

	@ApiResponses(value = { @ApiResponse(code = 200, message = STATUS_CODE_200),
			@ApiResponse(code = 204, message = STATUS_CODE_204), @ApiResponse(code = 400, message = STATUS_CODE_400),
			@ApiResponse(code = 401, message = STATUS_CODE_401), @ApiResponse(code = 403, message = STATUS_CODE_403),
			@ApiResponse(code = 404, message = STATUS_CODE_404), @ApiResponse(code = 500, message = STATUS_CODE_500) })
	@ApiOperation(value = API_REALIZAR_LOGIN, response = ResponseEntity.class)
	@PostMapping(REALIZAR_LOGIN)
	public abstract ResponseEntity<RetornoAutenticacaoDTO> realizarLogin(
			@ApiParam("Meus parametros") AutenticacaoDTO autenticacaoDTO);

}
