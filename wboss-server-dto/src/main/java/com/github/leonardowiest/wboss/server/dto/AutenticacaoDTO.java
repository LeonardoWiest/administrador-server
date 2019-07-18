package com.github.leonardowiest.wboss.server.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement
@ApiModel
@NoArgsConstructor
public final class AutenticacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Login do usuário")
	private String login;

	@ApiModelProperty(notes = "Senha do usuário")
	private String senha;

}
