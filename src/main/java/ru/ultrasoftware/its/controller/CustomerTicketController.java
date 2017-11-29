package ru.ultrasoftware.its.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.ultrasoftware.its.domain.OtrsTickets;
import ru.ultrasoftware.its.security.OtrsAuthenticationInfo;
import ru.ultrasoftware.its.service.SecurityService;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller
public class CustomerTicketController {

    @Autowired
    SecurityService securityService;

    @RequestMapping("/customer/tickets")
    public String tickets(Map<String, Object> model, HttpServletRequest request,HttpServletResponse response) {
        HttpSession s = request.getSession();

        UriComponents uri = UriComponentsBuilder
                .fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket")
                .queryParam("SessionID", securityService.currentUser().getSessionId() )
                .build();
        String urlString = uri.toUriString();
        RestTemplate restTemplate = new RestTemplate();
        OtrsTickets otrsTickets = restTemplate.getForObject(urlString, OtrsTickets.class);

        request.setAttribute("Tickets", otrsTickets.getTickets());

        return "/customer/tickets";
    }}