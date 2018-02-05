package ru.ultrasoftware.its.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.ultrasoftware.its.domain.OtrsUserTickets;
import ru.ultrasoftware.its.domain.TicketInfo;
import ru.ultrasoftware.its.service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value="/agent/tickets")
public class RestTicketViewController {

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ModelAndView ticketView(@PathVariable long id, Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException {

        UriComponents uri = UriComponentsBuilder
                .fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket")
                .queryParam("SessionID",  securityService.currentUser().getSessionId())
                .queryParam("OwnerIDs", securityService.currentUser().getAgentID())
                .build();
        String urlString = uri.toUriString();
        RestTemplate restTemplate = new RestTemplate();
        OtrsUserTickets otrsUserTickets = restTemplate.getForObject(urlString, OtrsUserTickets.class);

        uri = UriComponentsBuilder.fromHttpUrl(
                "http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket/" + id)
                .queryParam("SessionID", securityService.currentUser().getSessionId()).build();
        urlString = uri.toUriString();

        TicketInfo ticketInf = restTemplate.getForObject(urlString, TicketInfo.class);

        ModelAndView modelAndView = new ModelAndView("/agent/ticket_view");

        modelAndView.addObject("ticket", ticketInf.getTicketInf().get(0));

        return modelAndView;
    }
}