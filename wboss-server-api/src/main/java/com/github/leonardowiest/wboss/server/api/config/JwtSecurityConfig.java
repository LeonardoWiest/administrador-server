package com.github.leonardowiest.wboss.server.api.config;

import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.CONTEXT_PATH;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.MATCHER_ALL;
import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.MAX_AGE;
import static com.github.leonardowiest.wboss.server.util.constants.RequestConstants.REALIZAR_LOGIN;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.github.leonardowiest.wboss.server.security.JwtTokenFilterConfigurer;
import com.github.leonardowiest.wboss.server.security.JwtTokenProvider;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(1)
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.cors().configurationSource(corsBuilder()).and().csrf().disable();

		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.authorizeRequests().antMatchers(REALIZAR_LOGIN).permitAll();
		httpSecurity.authorizeRequests().antMatchers(CONTEXT_PATH + MATCHER_ALL).authenticated();
		httpSecurity.authorizeRequests().anyRequest().permitAll();

		httpSecurity.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

	}

	private CorsConfigurationSource corsBuilder() {

		CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
		corsConfiguration.setAllowedMethods(
				Arrays.asList(POST.toString(), DELETE.toString(), GET.toString(), PATCH.toString(), PUT.toString()));
		corsConfiguration.setMaxAge(MAX_AGE);

		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration(MATCHER_ALL, corsConfiguration);

		return urlBasedCorsConfigurationSource;

	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}

}
