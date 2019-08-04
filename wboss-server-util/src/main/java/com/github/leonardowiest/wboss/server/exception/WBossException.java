package com.github.leonardowiest.wboss.server.exception;

import lombok.Getter;

@Getter
public final class WBossException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String codigo;

    private final String mensagem;

    public WBossException(String codigo, String mensagem) {

        super(mensagem);

        this.codigo = codigo;
        this.mensagem = mensagem;

    }

    public WBossException(Throwable throwable) {

        super(throwable);

        this.codigo = "";
        this.mensagem = throwable.getMessage();

    }

}
