package com.github.leonardowiest.stone.server.api.config;

import static com.github.leonardowiest.stone.server.util.constants.MensagemConstants.USUARIO_SENHA_INVALIDOS;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.github.leonardowiest.stone.server.exceptions.StoneException;
import com.github.leonardowiest.stone.server.resources.ResourceException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StoneException.class)
    protected ResponseEntity<?> handleBadRequest(StoneException e) {
        return new ResponseEntity<>(e.getExceptionModel(), BAD_REQUEST);
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    protected ResponseEntity<?> handleForbidden(InternalAuthenticationServiceException e) {
        return new ResponseEntity<>(ResourceException.getException(USUARIO_SENHA_INVALIDOS).getExceptionModel(), FORBIDDEN);
    }

}
