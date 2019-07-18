package com.github.leonardowiest.wboss.server.api.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.github.leonardowiest.wboss.server.api.AutenticacaoController;
import com.github.leonardowiest.wboss.server.dto.AutenticacaoDTO;
import com.github.leonardowiest.wboss.server.dto.RetornoAutenticacaoDTO;

@RestController
public class AutenticacaoControllerImpl implements AutenticacaoController {

	@Override
	public ResponseEntity<RetornoAutenticacaoDTO> realizarLogin(AutenticacaoDTO autenticacaoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
