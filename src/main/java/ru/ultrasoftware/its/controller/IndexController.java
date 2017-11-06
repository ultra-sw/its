package ru.ultrasoftware.its.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.*;
import ru.ultrasoftware.its.security.OtrsAuthenticationProvider;

@Controller
public class IndexController {

    // inject via application.properties
    @Value("${application.message:Hello World}")
    private String message;

    @GetMapping("/")
    @PostMapping("/")
    public String root(Map<String, Object> model,HttpServletRequest request, HttpServletResponse response) {
        model.put("message", this.message);
        HttpSession session = request.getSession();
        session.setAttribute("sessionID", OtrsAuthenticationProvider.session);
        model.put("user",OtrsAuthenticationProvider.username);
        return "index";
    }
    @RequestMapping("/login")
    public String login(@RequestParam(value = "error",required = false) String error, Map<String, Object> model) {
        model.put("message", this.message);
        if (error != null)
            	 model.put("wrong_text", "Неверное имя пользователя или пароль. Проверьте правильность введённых данных");
        return "login";        
    }
    @RequestMapping("/enter")
    public String enter(Map<String, Object> model) {
        model.put("message", this.message);
        return "enter";
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

 /*   @RequestMapping("/")
        public String session (Model model) {
          model.addAttribute("session",OtrsAuthenticationProvider.session);
            System.out.println(OtrsAuthenticationProvider.session);
            return "index";
        }*/

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
