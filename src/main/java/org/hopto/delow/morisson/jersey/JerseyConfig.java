package org.hopto.delow.morisson.jersey;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.hopto.delow.morisson.guice.GuiceInjectorFactory;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;

class JerseyConfig extends ResourceConfig {

    @Inject
    public JerseyConfig(ServiceLocator serviceLocator) {
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(GuiceInjectorFactory.getGuiceInjector());

        register(JacksonFeature.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}