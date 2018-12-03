package org.hopto.delow.morisson.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.hopto.delow.morisson.controllers.test.TestModule;
import org.hopto.delow.morisson.jersey.BootstrapModule;
import org.hopto.delow.morisson.thymeleaf.ThymeleafModule;

public class GuiceInjectorFactory {
    private static Injector guiceInjector = null;

    private GuiceInjectorFactory(){}

    public static Injector getGuiceInjector() {
        if (guiceInjector == null) {
            guiceInjector = Guice.createInjector(Stage.DEVELOPMENT, new BootstrapModule(), new ThymeleafModule(), new JpaPersistModule("cardService"), new TestModule());
        }
        return guiceInjector;
    }
}
