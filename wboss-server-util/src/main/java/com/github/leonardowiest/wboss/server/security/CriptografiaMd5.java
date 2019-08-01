package com.github.leonardowiest.wboss.server.security;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CriptografiaMd5 {

    public static String converterStringParaMd5(String valor) {

        if (valor.isEmpty()) {
            return null;
        }

        Logger logger = LoggerFactory.getLogger(CriptografiaMd5.class);

        String retornoMd5 = null;

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            BigInteger hash = new BigInteger(1, md.digest(valor.getBytes("UTF-8")));

            retornoMd5 = String.format("%1$032x", hash);

        } catch (Exception e) {
            logger.error("Não foi possível converter o valor em formato Md5: " + e);
        }

        return retornoMd5;

    }

}
