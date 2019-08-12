package com.github.leonardowiest.stone.server.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.leonardowiest.stone.server.security.CriptografiaMd5;

@Configuration
public class PasswordEncoderConfiguration {

    @Value("${wboss.global.secret.key}")
    private String chaveSecreta;

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {

                return CriptografiaMd5.converterStringParaMd5(chaveSecreta.concat(rawPassword.toString()));

            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {

                return CriptografiaMd5.converterStringParaMd5(chaveSecreta.concat(rawPassword.toString())).equals(encodedPassword);

            }

        };

    }
}
