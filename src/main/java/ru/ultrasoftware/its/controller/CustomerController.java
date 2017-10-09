package ru.ultrasoftware.its.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ultrasoftware.its.service.SecurityService;

import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private static final String LOGIN_PAGE = "customer/login";

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Autowired
    SecurityService securityService;

    @GetMapping(value = "/login")
    public String renderLoginPage(Map<String, Object> model) {
        return LOGIN_PAGE;
    }

    @PostMapping(value = "/login")
    public String doLogin(@RequestParam(value = USERNAME, required = true) String username,
                          @RequestParam(value = PASSWORD, required = true) String password,
                          ModelMap model, RedirectAttributes attributes) {
        String customerInfo = securityService.authorize(username, password);
        if(customerInfo != null) {
            attributes.addFlashAttribute("customerInfo", customerInfo);
            return "redirect:/";
        } else {
            model.addAttribute("success", false);
            return LOGIN_PAGE;
        }
    }
}
