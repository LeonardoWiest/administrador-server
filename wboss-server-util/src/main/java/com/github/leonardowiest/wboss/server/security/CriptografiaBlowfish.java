package com.github.leonardowiest.wboss.server.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaBlowfish {

    public static void main(String[] args) {

        String cript = criptografarDescriptografar("tozetto2019", true);

        criptografarDescriptografar(cript, false);

    }

    public static final String SECRET_KEY = "Sysmo$#_clpfcc";

    private static final String UTF_8 = "UTF-8";

    public static final String ALGORITM = "Blowfish";

    private CriptografiaBlowfish() {

    }

    public static String criptografarDescriptografar(String conteudo, Boolean acaoCriptografar) {

        try {

            Cipher cipher = Cipher.getInstance(ALGORITM);

            cipher.init(acaoCriptografar ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, new SecretKeySpec(SECRET_KEY.getBytes(UTF_8), ALGORITM));

            return acaoCriptografar ? bytesToHex(cipher.doFinal(conteudo.getBytes(UTF_8))) : new String(cipher.doFinal(hexToBytes(conteudo)));

        } catch (Exception e) {
            return null;
        }

    }

    public static String bytesToHex(byte[] valor) {

        if (valor == null) {
            return null;
        } else {

            String retornoHex = "";

            for (int i = 0; i < valor.length; i++) {

                retornoHex = ((valor[i] & 0xFF) < 16) ? retornoHex + "0" + java.lang.Integer.toHexString(valor[i] & 0xFF)
                        : retornoHex + java.lang.Integer.toHexString(valor[i] & 0xFF);

            }

            return retornoHex.toUpperCase();

        }
    }

    public static byte[] hexToBytes(String valor) {

        if (valor == null) {

            return null;

        } else if (valor.length() < 2) {

            return null;

        } else {

            int len = valor.length() / 2;

            byte[] retornoByte = new byte[len];

            for (int i = 0; i < len; i++) {
                retornoByte[i] = (byte) Integer.parseInt(valor.substring(i * 2, i * 2 + 2), 16);
            }

            return retornoByte;
        }

    }

}