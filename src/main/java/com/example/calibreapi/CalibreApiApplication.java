package com.example.calibreapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class CalibreApiApplication {

    private static final Logger log = LoggerFactory.getLogger(CalibreApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CalibreApiApplication.class, args);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEvent() {
        return event -> {
            Environment env = event.getApplicationContext().getEnvironment();
            String port = env.getProperty("server.port", "8080");
            String host = "localhost";
            try {
                host = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                log.warn("Impossible de récupérer l'adresse IP locale, utilisation de 'localhost'");
            }
            log.info("----------------------------------------------------------");
            log.info("Application '{}' is running! Access URLs:", env.getProperty("spring.application.name", "calibre-api"));
            log.info("  Local: 		http://localhost:{}", port);
            log.info("  External: 	http://{}:{}", host, port);
            log.info("----------------------------------------------------------");
        };
    }

}
