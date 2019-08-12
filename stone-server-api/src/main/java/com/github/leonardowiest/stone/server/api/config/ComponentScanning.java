package com.github.leonardowiest.stone.server.api.config;

import static com.github.leonardowiest.stone.server.util.constants.GlobalConstants.PKG_SERVICE;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration()
@ComponentScan(lazyInit = true, basePackages = { PKG_SERVICE })
public class ComponentScanning {
}
