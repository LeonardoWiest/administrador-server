package com.github.leonardowiest.stone.server.api.config;

import static com.github.leonardowiest.stone.server.util.constants.GlobalConstants.PKG_API;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.github.leonardowiest.stone.server.documentation.SwaggerDocumentationConfig;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class WBossDocumentation {

    @Bean
    @Lazy
    public Docket swaggerConfigurationMonitor() {

        return new SwaggerDocumentationConfig(
                new ApiInfo("WBoss Server", "Documentação On-Line", "1.0", "Terms of service",
                        new Contact("Leonardo Wiest", "https://github.com/LeonardoWiest/", "leonardowiest@hotmail.com"), "", "", new ArrayList<>()),
                PKG_API).produces().groupName("wboss-server");

    }

}
