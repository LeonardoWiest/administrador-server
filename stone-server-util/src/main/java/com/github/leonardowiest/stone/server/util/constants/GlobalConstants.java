package com.github.leonardowiest.stone.server.util.constants;

public final class GlobalConstants {

    public static final String PROTOCOLO_HTTP = "http";
    public static final String CONTEXT_PATH = "/stone/bs";
    public static final String MATCHER_ALL = "/**";
    public static final Long JWT_VALIDITY_MILLISECONDS = 3600000L;
    public static final String JWT_BEARER = "Bearer ";
    public static final String JWT_BASIC = "Basic ";
    public static final String AUTHORIZATION = "Authorization";
    public static final Long MAX_AGE = 3600L;

    public static String UNIVERSAL_SECRET_KEY = "*!\\\\Stonn$$sS980oo//";

    public static final String USUARIO_PADRAO = "stone";
    public static final String USUARIO_ADMIN = "stone-admin";
    public static final String SENHA_PADRAO = "123456";

    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_ACTUATOR = "ACTUATOR";

    public static final String PKG_PRINCIPAL = "com.github.leonardowiest.stone.server";
    public static final String PKG_API = PKG_PRINCIPAL + ".api";
    public static final String PKG_SERVICE = PKG_PRINCIPAL + ".service";

}
