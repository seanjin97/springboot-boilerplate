package com.group8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@SpringBootApplication(
        scanBasePackages = "com.group8"
)

public class Entrypoint {
    private static final Logger logger = LogManager.getLogger(Entrypoint.class);

    @PostConstruct
    public void startupApplication() {
        logger.info("Server started.");
    }

    @PreDestroy
    public void shutdownApplication() {
        logger.fatal("Server stopped.");
    }

    public static void main(String[] args) {
        if (logger.isDebugEnabled()) {
            SpringApplication.run(Entrypoint.class, args);
        } else {
            logger.fatal("Logging not enabled. Please enable logging.");
        }
    }

}
