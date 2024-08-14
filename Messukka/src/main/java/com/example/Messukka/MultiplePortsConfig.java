package com.example.Messukka;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiplePortsConfig {

    @Value("${server.port}")
    private int primaryPort;

    @Value("${server.additional-port}")
    private int additionalPort;

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(primaryPort);
        factory.addAdditionalTomcatConnectors(createConnector(additionalPort));
        return factory;
    }

    private Connector createConnector(int port) {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setPort(port);
        return connector;
    }
}
