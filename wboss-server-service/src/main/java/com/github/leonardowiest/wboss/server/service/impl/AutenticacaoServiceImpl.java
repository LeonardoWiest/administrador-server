package com.github.leonardowiest.wboss.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.github.leonardowiest.wboss.server.dto.AutenticacaoDTO;
import com.github.leonardowiest.wboss.server.dto.RetornoAutenticacaoDTO;
import com.github.leonardowiest.wboss.server.repository.UsuarioRepository;
import com.github.leonardowiest.wboss.server.security.JwtTokenProviderService;
import com.github.leonardowiest.wboss.server.service.AutenticacaoService;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

	@Lazy
	@Autowired
	AuthenticationManager authenticationManager;

	@Lazy
	@Autowired
	UsuarioRepository usuarioRepository;

	@Lazy
	@Autowired
	JwtTokenProviderService jwtTokenProviderService;

	@Override
	public RetornoAutenticacaoDTO realizarLogin(AutenticacaoDTO autenticacaoDTO) {

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				autenticacaoDTO.getLogin(), autenticacaoDTO.getSenha());

		setarSecurityContext(authenticationManager.authenticate(usernamePasswordAuthenticationToken));

		return buscarToken(autenticacaoDTO.getLogin());
	}

	private void setarSecurityContext(Authentication authentication) {

		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);

	}

	private RetornoAutenticacaoDTO buscarToken(String login) {

		return new RetornoAutenticacaoDTO(jwtTokenProviderService.gerarToken(usuarioRepository.findByLogin(login)));

	}

}
