package com.github.leonardowiest.wboss.server.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.github.leonardowiest.wboss.server.security.AuthenticationManagerBuilderConfig;
import com.github.leonardowiest.wboss.server.security.HttpSecurityConfig;

@Configuration
@EnableWebSecurity
public class WBossSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		new AuthenticationManagerBuilderConfig(auth).builder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		new HttpSecurityConfig(http).builder();
	}

}
