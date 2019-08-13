package com.github.leonardowiest.stone.server.api;

import static com.github.leonardowiest.stone.server.util.constants.GlobalConstants.PROTOCOLO_HTTP;
import static com.github.leonardowiest.stone.server.util.constants.RequestConstants.AUTENTICACAO_CONTROLLER;
import static com.github.leonardowiest.stone.server.util.constants.RequestConstants.PARAMETROS;
import static com.github.leonardowiest.stone.server.util.constants.RequestConstants.REALIZAR_LOGIN;
import static com.github.leonardowiest.stone.server.util.constants.RequestConstants.TAG_AUTENTICACAO;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.leonardowiest.stone.server.dto.AutenticacaoDTO;
import com.github.leonardowiest.stone.server.dto.RetornoAutenticacaoDTO;
import com.github.leonardowiest.stone.server.util.annotations.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = { TAG_AUTENTICACAO }, protocols = PROTOCOLO_HTTP)
@RequestMapping(value = AUTENTICACAO_CONTROLLER, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public interface AutenticacaoController {

    @ApiOperation(value = REALIZAR_LOGIN, response = RetornoAutenticacaoDTO.class)
    @Response
    @PostMapping(REALIZAR_LOGIN)
    public abstract RetornoAutenticacaoDTO realizarLogin(@ApiParam(PARAMETROS) AutenticacaoDTO autenticacaoDTO);

}
