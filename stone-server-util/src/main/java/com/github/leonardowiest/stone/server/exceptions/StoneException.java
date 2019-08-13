package com.github.leonardowiest.stone.server.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class StoneException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Getter
    private final ExceptionModel exceptionModel;

    public StoneException(String codigo, String mensagem) {

        super(mensagem);

        this.exceptionModel = new ExceptionModel(codigo, mensagem);
    }

    public StoneException(String codigo, String mensagem, Throwable throwable) {

        super(throwable);

        this.exceptionModel = new ExceptionModel(codigo, mensagem);
    }

}

@Data
@AllArgsConstructor
class ExceptionModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigo;

    private String mensagem;
}
