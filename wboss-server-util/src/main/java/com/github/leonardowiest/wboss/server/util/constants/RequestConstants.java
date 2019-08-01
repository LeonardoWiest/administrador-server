package com.github.leonardowiest.wboss.server.util.constants;

public final class RequestConstants {

    public static final String PARAMETROS = "Paramêtros";

    /**
     * 
     * AutenticacaoController
     * 
     */
    public static final String TAG_AUTENTICACAO = "Autenticação";
    public static final String AUTENTICACAO_CONTROLLER = GlobalConstants.CONTEXT_PATH + "/autenticacao";
    public static final String REALIZAR_LOGIN = "/realizarLogin";
    public static final String API_REALIZAR_LOGIN = AUTENTICACAO_CONTROLLER + REALIZAR_LOGIN;

    private RequestConstants() {

    }

}
