package com.github.leonardowiest.wboss.server.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

	@Bean
	public Docket produces() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.github.leonardowiest.wboss.server.api"))
				.paths(PathSelectors.any()).build().apiInfo(this.infoBuilder().build());
	}

	private ApiInfoBuilder infoBuilder() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title("REST API - Wboss Server");
		apiInfoBuilder.description("Documentação On-line");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Terms of service");
		apiInfoBuilder.contact("Leonardo Wiest");

		return apiInfoBuilder;

	}

}
