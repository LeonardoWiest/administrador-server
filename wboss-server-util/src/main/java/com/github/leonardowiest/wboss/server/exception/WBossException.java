package com.github.leonardowiest.wboss.server.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public final class WBossException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Getter
    private final ExceptionResponse exceptionResponse;

    public WBossException(String mensagem) {

        super(mensagem);

        this.exceptionResponse = new ExceptionResponse(mensagem);

    }

}

@AllArgsConstructor
@Data
class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mensagem;

}
