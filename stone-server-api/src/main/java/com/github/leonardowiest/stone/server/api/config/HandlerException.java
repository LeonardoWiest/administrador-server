package com.github.leonardowiest.stone.server.api.config;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.github.leonardowiest.stone.server.exceptions.StoneException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StoneException.class)
    protected ResponseEntity<?> handleStoneException(StoneException e) {
        return new ResponseEntity<>(e.getExceptionModel(), BAD_REQUEST);
    }

}
