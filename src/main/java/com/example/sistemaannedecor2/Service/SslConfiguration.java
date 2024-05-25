package com.example.sistemaannedecor2.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.SslStoreProvider;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@Configuration
public class SslConfiguration {

    @Bean
    public WebServerFactoryCustomizer<WebServerFactory> webServerFactoryCustomizer() {
        return factory -> {
            if (factory instanceof TomcatServletWebServerFactory) {
                TomcatServletWebServerFactory tomcatFactory = (TomcatServletWebServerFactory) factory;
                tomcatFactory.setSsl(getSsl());
            }
        };
    }

    private Ssl getSsl() {
        Ssl ssl = new Ssl();
        try {
            File keyStore = ResourceUtils.getFile("/Users/federicocalvino/IdeaProjects/AnneDecorApi/keystore.jks");
            ssl.setKeyStore(keyStore.getAbsolutePath());
            ssl.setKeyStorePassword("Anne138018");
            ssl.setKeyPassword("Anne138018");
            ssl.setKeyStoreType("PKCS12");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ssl;
    }
}