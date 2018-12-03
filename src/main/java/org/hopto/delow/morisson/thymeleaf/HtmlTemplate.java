package org.hopto.delow.morisson.thymeleaf;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

//@Data
public class HtmlTemplate {

    private String templateName;

    private Map<String, Object> variables = new HashMap<>();

    public HtmlTemplate(String templateName) {
        this.templateName = templateName;
    }

    public void setVariable(String name, Object value) {
        variables.put(name, value);
    }

    public String getTemplateName() {
        return templateName;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }
}
