package ru.ultrasoftware.its.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ultrasoftware.its.security.OtrsAuthenticationInfo;
import ru.ultrasoftware.its.service.SecurityService;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller
public class IndexController {
    // inject via application.properties
    @Value("${application.message:Hello World}")
    private String message;

    @Autowired
    HttpSession httpSession;

    @Autowired
    SecurityService securityService;

    @RequestMapping("/")
    public String login(@RequestParam(value = "error",required = false) String error, Map<String, Object> model) {
        OtrsAuthenticationInfo user = securityService.currentUser();
        model.put("message", this.message);
        if(error != null)
            	 model.put("wrong_text", "Неверное имя пользователя или пароль. Проверьте правильность введённых данных");
        if(user != null) {
            if(securityService.currentUser().getRoleAgent() == true){
                return "agent/index";
            } else {
                return "customer/index";
            }
        }
        return "login";
    }


    @RequestMapping("/out")
    public String out() {
        securityService.logout();
//        OtrsAuthenticationInfo user = securityService.currentUser();
//        if(user != null) {
//            httpSession.invalidate();
//        }
        return "login";
    }
    @RequestMapping("/test")
    public String test(Map<String, Object> model) {
        model.put("message", this.message);
        return "test";
    }
    @RequestMapping("/locale")
    public String home(Locale locale) {
        return locale.toString();
    }
	public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
    /*
        @RequestParam - указываем, что данный аргумент метода, является значение с формы с именем как название аргумент в java.
        author, text - приходят значения из input тегов.
     */
    public String showMessage(@RequestParam String login, @RequestParam String password, ModelMap model) {
        model.addAttribute(LOGIN, login);
        model.addAttribute(PASSWORD, password);
        return "login";
    }
}
