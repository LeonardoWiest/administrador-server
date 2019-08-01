package com.github.leonardowiest.wboss.server.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(2)
public class AuthenticationMananagerProvider extends WebSecurityConfigurerAdapter {

    /**
     * @description
     * 
     *              Força a injeção do Bean AuthenticationManager
     * 
     */

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}