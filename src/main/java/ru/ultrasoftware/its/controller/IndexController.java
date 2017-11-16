package ru.ultrasoftware.its.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ultrasoftware.its.security.OtrsAuthenticationProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller
public class IndexController {
    public static String sessionID ="";
    public static boolean agent=true;
    // inject via application.properties
    @Value("${application.message:Hello World}")
    private String message;


    @RequestMapping("/")
    public String login(@RequestParam(value = "error",required = false) String error, Map<String, Object> model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String page;
        model.put("message", this.message);
        System.out.println(agent);
        if (error != null)
            	 model.put("wrong_text", "Неверное имя пользователя или пароль. Проверьте правильность введённых данных");
        if(sessionID.length()>1){
            session.setAttribute("session",sessionID);
            if(agent==true)return "agent/index";
            else{return "customer/index";}}

        return "login";        
    }


    @RequestMapping("/out")
    public String out(Map<String, Object> model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        sessionID="";
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
