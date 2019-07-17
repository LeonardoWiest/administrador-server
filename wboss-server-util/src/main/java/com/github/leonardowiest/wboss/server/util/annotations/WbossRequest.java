package com.github.leonardowiest.wboss.server.util.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface WbossRequest {

	@AliasFor(annotation = RequestMapping.class, attribute = "value")
	String value();

}
