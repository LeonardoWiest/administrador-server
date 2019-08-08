package com.github.leonardowiest.wboss.server.resources;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.leonardowiest.wboss.server.exception.WBossException;

public class ResourceException {

    private static ResourceBundle bundle;

    private static Logger logger = LoggerFactory.getLogger(ResourceException.class);

    private ResourceException() {

    }

    public static String tratarMensagem(String mensagem) {

        String mensagemTratada = "";

        return mensagemTratada;

    }

    public static WBossException getException(String codigo) {

        String mensagem = adquirirProperty(codigo);

        logger.error("Property ".concat(codigo).concat(" ==> ").concat(mensagem));

        return new WBossException(codigo, mensagem);

    }

    private static String adquirirProperty(String codigo) {

        bundle = ResourceBundle.getBundle("pt-BR");

        try {
            return new String(bundle.getString(codigo).getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}
