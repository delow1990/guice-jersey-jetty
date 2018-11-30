package org.hopto.delow.morisson;

import org.hopto.delow.morisson.guice.GuiceInjectorFactory;
import org.hopto.delow.morisson.jersey.JerseyBootstrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        JerseyBootstrapper bootstrapper = GuiceInjectorFactory.getGuiceInjector().getInstance(JerseyBootstrapper.class);
        bootstrapper.setupServer();
        try {
            bootstrapper.startServer();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}