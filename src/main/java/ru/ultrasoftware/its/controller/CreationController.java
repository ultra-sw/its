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
import ru.ultrasoftware.its.domain.Article;
import ru.ultrasoftware.its.domain.Ticket;
import ru.ultrasoftware.its.domain.TicketCreate;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by pwmn on 31/10/2017.”
 */
@Controller

public class CreationController {


    @RequestMapping("/create")
    public String create(Map<String,Object> model,HttpServletRequest request){
        HttpSession s = request.getSession();
        if(s.getAttribute("session")!=null){
        if(IndexController.agent==true)return "agent/create";
        if(IndexController.agent==false)return "customer/create";}
        return "login";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    /*
        @RequestParam - указываем, что данный аргумент метода, является значение с формы с именем как название аргумент в java.
        author, text - приходят значения из input тегов.
     */
    public String createTicket(@RequestParam String title, @RequestParam String email, @RequestParam String queue,
                              @RequestParam String state, @RequestParam String priority, @RequestParam String subject,
                              @RequestParam String body, ModelMap model) {

        //GET SESSION ID BEGIN
        String sessionID = IndexController.sessionID;
        //GET SESSION ID END

        //OTLADKA DLYA STRANICI successCreate BEGIN
        model.addAttribute("title",title);
        model.addAttribute("email",email);
        model.addAttribute("queue",queue);
        model.addAttribute("state",state);
        model.addAttribute("priority",priority);
        model.addAttribute("subject",subject);
        model.addAttribute("body",body);
        //OTLADKA DLYA STRANICI successCreate END

        //JSON PROPERTIES SETTERS BEGIN
        //Создаем новый экземпляр класса
        Ticket ticket = new Ticket();
        //ticket.setUserLogin("wow.timur@yandex.ru");
        //ticket.setPassword("12345");
        ticket.setTitle("@JsonProperty testing TITLE");
        ticket.setCustomerUser("wow.timur@yandex.ru");
        ticket.setQueue("Junk");
        ticket.setState("open");
        ticket.setPriority("3 normal");
        Article article = new Article();
        article.setSubject("@JsonProperty testing");
        article.setBody("Success");
        article.setContentType("text/plain; charset=utf8");
        TicketCreate ticketCreate=new TicketCreate();
        ticketCreate.setTicket(ticket);
        ticketCreate.setArticle(article);
        //JSON PROPERTIES SETTERS END

        //REQUEST BEGIN
       UriComponents uri= UriComponentsBuilder
                .fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket")
              //  .queryParam("UserLogin","wow.timur@yandex.ru")
               // .queryParam("Password","12345")
               .queryParam("SessionID",sessionID)
                .build();
        String urlString = uri.toUriString();
        RestTemplate rt = new RestTemplate();
        String response = rt.postForObject(urlString,ticketCreate,String.class);
        System.out.println(response);
        //REQUEST END

        model.put("OMG",response+"SID:"+sessionID); //otladka

       return "successCreate";
    }

}
