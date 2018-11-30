package org.hopto.delow.morisson.controllers;

import org.hopto.delow.morisson.thymeleaf.HtmlTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/msg")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Message {

    @Inject
    @Named("serverPort")
    private Integer port;

    @GET
    public String getMessage() {
        return "Hey!, I'm running on port: " + port;
    }


    @GET
    @Path("/test")
    public DefaultResponse getResponse() {
        return new DefaultResponse();
    }

    @GET
    @Path("/template")
    @Produces(MediaType.TEXT_HTML)
    public HtmlTemplate getTemplate() {
        HtmlTemplate template = new HtmlTemplate("template");
        return template;
    }
}
