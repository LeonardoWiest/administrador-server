package com.github.leonardowiest.stone.server.properties;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.github.leonardowiest.stone.server.resources.ResourceException;

public final class ExceptionProperty {

    public static String getPropertyUsuario(String propriedade) {

        try {
            return new String(ResourceBundle.getBundle("pt-BR").getString(propriedade).getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            Logger.getLogger(ResourceException.class.getName()).severe("Chave da propriedade: " + propriedade + " não esta configurada.");
        }

        return "";

    }

}
