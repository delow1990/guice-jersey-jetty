package org.hopto.delow.morisson.thymeleaf;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafModule extends AbstractModule {

    @Provides
    public ITemplateEngine getTemplateEngine() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();

        templateEngine.setTemplateResolver(resolver);

        return templateEngine;
    }

}
