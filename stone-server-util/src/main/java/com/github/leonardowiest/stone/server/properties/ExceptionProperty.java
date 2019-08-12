package com.github.leonardowiest.stone.server.properties;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class ExceptionProperty {

    private static ResourceBundle bundle;

    private ExceptionProperty() {

    }

    public static String getMensagemProperty(String codigo) {

        bundle = ResourceBundle.getBundle("pt-br");

        try {
            return new String(bundle.getString(codigo).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "";

    }

}
