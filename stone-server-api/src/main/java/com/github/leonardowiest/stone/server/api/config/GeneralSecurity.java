package com.github.leonardowiest.stone.server.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.github.leonardowiest.stone.server.security.AuthenticationManagerBuilderConfig;
import com.github.leonardowiest.stone.server.security.HttpSecurityConfig;

@Configuration
@EnableWebSecurity
public class GeneralSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

        new AuthenticationManagerBuilderConfig(authenticationManagerBuilder).builder();

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        new HttpSecurityConfig(httpSecurity).builder();

    }

}
