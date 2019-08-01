package com.github.leonardowiest.wboss.server.security;

import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.ROLE_ACTUATOR;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.ROLE_ADMIN;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.ROLE_USER;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.SENHA_PADRAO;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.USUARIO_ADMIN;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.USUARIO_PADRAO;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public final class AuthenticationManagerBuilderConfig {

    private final AuthenticationManagerBuilder aManagerBuilder;

    public AuthenticationManagerBuilderConfig(AuthenticationManagerBuilder parametroAManagerBuilder) {
        this.aManagerBuilder = parametroAManagerBuilder;
    }

    public void builder() throws Exception {
        this.aManagerBuilder.inMemoryAuthentication().withUser(USUARIO_PADRAO).password("{noop}" + SENHA_PADRAO).roles(ROLE_USER).and()
                .withUser(USUARIO_ADMIN).password("{noop}" + SENHA_PADRAO).roles(ROLE_USER, ROLE_ADMIN, ROLE_ACTUATOR);
    }

}
