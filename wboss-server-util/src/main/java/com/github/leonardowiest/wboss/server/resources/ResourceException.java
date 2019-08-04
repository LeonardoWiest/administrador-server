package com.github.leonardowiest.wboss.server.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.leonardowiest.wboss.server.exception.WBossException;

public class ResourceException {

    private static Logger logger = LoggerFactory.getLogger(ResourceException.class);

    private ResourceException() {

    }

    public static String tratarMensagem(String mensagem) {

        String mensagemTratada = "";

        return mensagemTratada;

    }

    public static WBossException getException(String codigo) {

        String mensagem = "";

        return new WBossException(codigo, mensagem);

    }

}
