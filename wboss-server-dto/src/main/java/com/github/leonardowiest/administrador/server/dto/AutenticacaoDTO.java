package com.github.leonardowiest.administrador.server.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
public final class AutenticacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Login do usuário")
	private String login;

	@ApiModelProperty(notes = "Senha do usuário")
	private String senha;

}
