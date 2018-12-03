package org.hopto.delow.morisson.jersey;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.ServletModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class BootstrapModule extends ServletModule {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapModule.class);

    @Override
    protected void configureServlets() {

        filter("/*").through(PersistFilter.class);

        Properties prop = new Properties();
        try {
            prop.load(BootstrapModule.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        Names.bindProperties(binder(), prop);
        bind(JerseyBootstrapper.class);


    }
}