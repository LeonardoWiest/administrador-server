package com.github.leonardowiest.wboss.server.security;

import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.MATCHER_ALL;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.ROLE_USER;

import java.util.Arrays;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public final class HttpSecurityConfig {

    private final HttpSecurity aHttpSecurity;

    public HttpSecurityConfig(HttpSecurity parametroAHttpSecurity) {
        this.aHttpSecurity = parametroAHttpSecurity;
    }

    public void builder() throws Exception {
        this.aHttpSecurity.cors().configurationSource(getCorsBuilder()).and().httpBasic().and().authorizeRequests().antMatchers(MATCHER_ALL)
                .hasRole(ROLE_USER).and().csrf().disable().headers().frameOptions().disable();
    }

    private CorsConfigurationSource getCorsBuilder() {

        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList(HttpMethod.POST.toString(), HttpMethod.DELETE.toString(), HttpMethod.GET.toString(),
                HttpMethod.PATCH.toString(), HttpMethod.PUT.toString()));
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(MATCHER_ALL, configuration);

        return null;
    }

}
