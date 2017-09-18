package ru.ultrasoftware.its.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
public class IndexController {

    // inject via application.properties
    @Value("${application.message:Hello World}")
    private String message;

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("message", this.message);
        return "index";
    }

    @RequestMapping("/locale")
    public String home(Locale locale) {
        return locale.toString();
    }
}
