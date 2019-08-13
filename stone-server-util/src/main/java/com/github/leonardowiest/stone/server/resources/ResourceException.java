package com.github.leonardowiest.stone.server.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.leonardowiest.stone.server.exceptions.StoneException;
import com.github.leonardowiest.stone.server.properties.ExceptionProperty;

public final class ResourceException {

    private static Logger logger = LoggerFactory.getLogger(ResourceException.class);

    public static StoneException getException(String propriedade) {

        String mensagem = ExceptionProperty.getPropertyUsuario(propriedade);

        logger.error(propriedade.concat(" - ").concat(mensagem));

        return new StoneException(propriedade, mensagem);
    }

}
