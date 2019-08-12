package com.github.leonardowiest.stone.server.documentation;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.http.MediaType;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerDocumentationConfig {

    private ApiInfo parametrosApiInfo;

    private String parametrosPackageREST;

    public SwaggerDocumentationConfig(ApiInfo apiInfo, String packageREST) {

        super();

        this.parametrosApiInfo = apiInfo;

        this.parametrosPackageREST = packageREST;

    }

    public Docket produces() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(parametrosApiInfo).select()
                .apis(RequestHandlerSelectors.basePackage(parametrosPackageREST)).paths(PathSelectors.any()).build()
                .enableUrlTemplating(Boolean.FALSE)
                .produces(new HashSet<String>(Arrays.asList(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE)))
                .consumes(new HashSet<String>(Arrays.asList(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE)))
                .globalOperationParameters(Arrays
                        .asList(new ParameterBuilder().name("Content-Type").description("Content-Type").defaultValue(MediaType.APPLICATION_JSON_VALUE)
                                .modelRef(new ModelRef("string")).parameterType("header").required(true).build()));

    }

}
