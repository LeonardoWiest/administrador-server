package com.github.leonardowiest.wboss.server;

import static com.github.leonardowiest.wboss.server.util.constants.GlobalConstants.PKG_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { PKG_API })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
