package org.hopto.delow.morisson.thymeleaf;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class HtmlTemplate {

    private String templateName;

    private Map<String, Object> variables = new HashMap<>();

    public HtmlTemplate(String templateName) {
        this.templateName = templateName;
    }
}
