package ru.ultrasoftware.its.controller;



import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.ultrasoftware.its.domain.TicketCreate;



import java.util.Map;

/**
 * Created by pwmn on 31/10/2017.”
 */
@Controller

public class CreationController {


    public String querry;
    @JsonProperty("Ticket")
    private TicketCreate ticketCreate;


    @RequestMapping("/create")
    public String create(Map<String,Object> model) {





        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    /*
        @RequestParam - указываем, что данный аргумент метода, является значение с формы с именем как название аргумент в java.
        author, text - приходят значения из input тегов.
     */
    public String createTicket(@RequestParam String title, @RequestParam String email,

                              @RequestParam String queue,
                              @RequestParam String state,
                              @RequestParam String priority,
                              @RequestParam String subject,
                              @RequestParam String body

                              ,ModelMap model) {

        //OTLADKA DLYA STRANICI successCreate
        model.addAttribute("title",title);
        model.addAttribute("email",email);
        model.addAttribute("queue",queue);
        model.addAttribute("state",state);
        model.addAttribute("priority",priority);
        model.addAttribute("subject",subject);
        model.addAttribute("body",body);
        //OTLADKA DLYA STRANICI successCreate

        //JSON PROPERTIES SETTERS BEGIN

        ticketCreate.setTitle(title);
        ticketCreate.setEmail(email);
        ticketCreate.setPriority(priority);
        ticketCreate.setSubject(subject);
        ticketCreate.setBody(body);

        //JSON PROPERTIES SETTERS END

        //REQUEST BEGIN

       UriComponents uri= UriComponentsBuilder

                .fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket")
                .queryParam("UserLogin","wow.timur@yandex.ru")
                .queryParam("Password","12345")
                .build();
        String urlString = uri.toUriString();
        RestTemplate rt= new RestTemplate();
        rt.postForObject(urlString,null,TicketCreate.class);

        //REQUEST END

        model.put("OMG",ticketCreate.getTitle()); //otladka

       return "successCreate";
    }

}
