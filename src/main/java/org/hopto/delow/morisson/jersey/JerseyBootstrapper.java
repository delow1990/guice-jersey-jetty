package org.hopto.delow.morisson.jersey;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.GuiceServletContextListener;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.servlet.ServletContainer;
import org.hopto.delow.morisson.Main;
import org.hopto.delow.morisson.guice.GuiceInjectorFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class JerseyBootstrapper {
    private int port;

    private Server jettyServer;

    @Inject
    public JerseyBootstrapper(@Named("serverPort") int port) {
        this.port = port;
    }

    public void setupServer() {
        ServletHolder holder = new ServletHolder(ServletContainer.class);
        holder.setInitParameter("javax.ws.rs.Application", JerseyConfig.class.getCanonicalName());
        holder.setInitParameter("jersey.config.server.provider.packages", Main.class.getPackage().getName());

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
        webAppContext.addServlet(holder, "/*");
        webAppContext.setResourceBase("/");
        webAppContext.setContextPath("/");
        webAppContext.addEventListener(new GuiceServletContextListener() {
            @Override
            protected Injector getInjector() {
                return GuiceInjectorFactory.getGuiceInjector();
            }
        });

        jettyServer = new Server(this.port);
        jettyServer.setHandler(webAppContext);
        webAppContext.setServer(jettyServer);
    }

    public void startServer() throws Exception {
        jettyServer.start();
        jettyServer.join();
    }

    public void stopServer() throws Exception {
        jettyServer.stop();
    }

    public void destroyServer() {
        jettyServer.destroy();
    }
}
