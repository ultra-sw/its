package ru.ultrasoftware.its.controller;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.ultrasoftware.its.Temp;
import ru.ultrasoftware.its.domain.OtrsSession;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pwmn on 31/10/2017.”
 */
@Controller

public class CreationController {

    public String querry;


    @RequestMapping("/create")
    public String create(Map<String,Object> model) {

        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    /*
        @RequestParam - указываем, что данный аргумент метода, является значение с формы с именем как название аргумент в java.
        author, text - приходят значения из input тегов.
     */
    public String showMessage(@RequestParam String title, @RequestParam String email,

                              @RequestParam String queue,
                              @RequestParam String state,
                              @RequestParam String priority,
                              @RequestParam String subject,
                              @RequestParam String body

                              ,ModelMap model) {


        //OTLADKA DLYA STRANICI USPEHA
        model.addAttribute("title",title);
        model.addAttribute("email",email);
        model.addAttribute("queue",queue);
        model.addAttribute("state",state);
        model.addAttribute("priority",priority);
        model.addAttribute("subject",subject);
        model.addAttribute("body",body);




        querry="{\"Ticket\": {\"UserLogin\": \""+email+"\",\"Password\": \"12345\",\"Title\": \""+title+"\",\"CustomerUser\": \""+email+"\",\"Queue\": \""+queue+"\",\"State\": \""+state+"\",\"Priority\": \""+priority+"\"},\"Article\": {\"Subject\": \""+subject+"\",\"Body\": \""+body+"\",\"ContentType\": \"text/plain; charset=utf8\"}}";
        model.put("pwmn3",querry);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(querry,headers);
        ResponseEntity<String> response = restTemplate.exchange("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket?UserLogin=wow.timur@yandex.ru&Password=12345", HttpMethod.POST,entity,String.class);
        model.put("response",response);

       return "successCreate";
    }



}
