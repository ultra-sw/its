package ru.ultrasoftware.its.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.ultrasoftware.its.domain.OtrsUserTickets;
import ru.ultrasoftware.its.domain.Ticket;
import ru.ultrasoftware.its.service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerTicketController {

    @Autowired
    SecurityService securityService;

    @RequestMapping("/customer/tickets")
    public ModelAndView tickets(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(
                "http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket")
                .queryParam("SessionID", securityService.currentUser().getSessionId()).build();
        String urlString = uri.toUriString();
        RestTemplate restTemplate = new RestTemplate();
        OtrsUserTickets otrsUserTickets = restTemplate.getForObject(urlString, OtrsUserTickets.class);

        List<Ticket> tickets = new ArrayList<Ticket>(otrsUserTickets.getTicketIds().size());
        for(Integer ticketId : otrsUserTickets.getTicketIds()) {
            //TODO тут нужно получить тикет по его id. Пока просто создам его тут.
            Ticket ticket = new Ticket();
            ticket.setId(ticketId);
            ticket.setTitle("Тикет " + ticketId);
            ticket.setState("Состояние " + ticketId);
            tickets.add(ticket);
        }
        ModelAndView mv = new ModelAndView("/customer/tickets");
        mv.addObject("tickets", tickets);

        return mv;
    }
}
