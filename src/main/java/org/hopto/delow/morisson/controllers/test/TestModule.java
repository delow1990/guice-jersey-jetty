package org.hopto.delow.morisson.controllers.test;

import com.google.inject.AbstractModule;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TestService.class);
    }
}
