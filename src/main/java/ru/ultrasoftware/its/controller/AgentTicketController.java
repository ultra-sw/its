package ru.ultrasoftware.its.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.ultrasoftware.its.domain.Content;
import ru.ultrasoftware.its.domain.OtrsUserTickets;
import ru.ultrasoftware.its.domain.Ticket;
import ru.ultrasoftware.its.domain.TicketInfo;
import ru.ultrasoftware.its.security.OtrsAuthenticationProvider;
import ru.ultrasoftware.its.service.SecurityService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
@Controller
public class AgentTicketController {

    @Autowired
    SecurityService securityService;

    @RequestMapping("/agent/tickets")
    public ModelAndView tickets(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException {
       UriComponents uri = UriComponentsBuilder
                .fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket")
                .queryParam("SessionID",  securityService.currentUser().getSessionId())
                .queryParam("OwnerIDs", securityService.currentUser().getAgentID())
                .build();
        String urlString = uri.toUriString();
        RestTemplate restTemplate = new RestTemplate();
        OtrsUserTickets otrsUserTickets = restTemplate.getForObject(urlString, OtrsUserTickets.class);
        List<Ticket> tickets = new ArrayList<Ticket>(otrsUserTickets.getTicketIds().size());
        for(Integer ticketId : otrsUserTickets.getTicketIds()) {
            uri = UriComponentsBuilder.fromHttpUrl(
                    "http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket/" + ticketId)
                    .queryParam("SessionID", securityService.currentUser().getSessionId()).build();
            urlString = uri.toUriString();
            TicketInfo ticketInf = restTemplate.getForObject(urlString, TicketInfo.class);
            if(!ticketInf.getTicketInf().isEmpty()) {
                Content ticket1 = ticketInf.getTicketInf().get(0);
                Ticket ticket = new Ticket();
                ticket.setId(ticketId);
                ticket.setTitle(ticket1.getTitle());
                ticket.setState(ticket1.getState());
                ticket.setCreated(ticket1.getCreated());
                tickets.add(ticket);
            }}
        ModelAndView mv = new ModelAndView("/agent/tickets");
        mv.addObject("tickets", tickets);

        return mv;
    }
}
