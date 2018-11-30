package org.hopto.delow.morisson.thymeleaf;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class ThymeleafProvider implements MessageBodyWriter<HtmlTemplate> {

    private final ITemplateEngine templateEngine;

    @Inject
    public ThymeleafProvider(ITemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return HtmlTemplate.class.isAssignableFrom(type);
    }

    @Override
    public void writeTo(HtmlTemplate htmlTemplate, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) {
        Context context = new Context();
        context.setVariables(htmlTemplate.getVariables());
        templateEngine.process(htmlTemplate.getTemplateName(), context, new OutputStreamWriter(new BufferedOutputStream(entityStream)));
    }
}
