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
import ru.ultrasoftware.its.domain.Content;
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

        Content ticketGet = ticketInf.getTicketInf().get(0);

        Integer escalationSolutionTime = ticketGet.getEscalationSolutionTime();
        String createBy = ticketGet.getCreateBy();
        String priority = ticketGet.getPriority();
        String customerID = ticketGet.getCustomerID();
        Integer responsibleID = ticketGet.getResponsibleID();
        Integer realTillTimeNotUsed = ticketGet.getRealTillTimeNotUsed();
        Integer escalationUpdateTime = ticketGet.getEscalationUpdateTime();
        Integer escalationResponseTime = ticketGet.getEscalationResponseTime();
        Integer typeID = ticketGet.getTypeID();
        String archiveFlag = ticketGet.getArchiveFlag();
        String untilTime = ticketGet.getUntilTime();
        Integer priorityID = ticketGet.getPriorityID();
        String getCreated = ticketGet.getCreated();
        Integer queueID = ticketGet.getQueueID();
        Integer ownerID = ticketGet.getOwnerID();
        String escalationTime = ticketGet.geEscalationTime();
        String owner = ticketGet.getOwner();
        String slaid = ticketGet.getSLAID();
        String unlockTimeout = ticketGet.getUnlockTimeout();
        String getLockID = ticketGet.getLockID();
        String customerUserID = ticketGet.getCustomerUserID();
        String stateID = ticketGet.getStateID();
        String groupID = ticketGet.getGroupID();
        String timeUnit = ticketGet.getTimeUnit();
        String serviceID = ticketGet.getServiceID();
        String lock = ticketGet.getLock();
        String state = ticketGet.getState();
        String type = ticketGet.getType();
        String responsible = ticketGet.getResponsible();
        String changeBy = ticketGet.getChangeBy();
        String stateType = ticketGet.getStateType();
        String queue = ticketGet.getQueue();
        String changed = ticketGet.getChanged();
        String ticketNumber = ticketGet.getTicketNumber();
        String title = ticketGet.getTitle();
        String age = ticketGet.getAge();
        Integer ticketID = ticketGet.getTicketID();

        ModelAndView modelAndView = new ModelAndView("/agent/ticket_view");

        modelAndView.addObject("escalationSolutionTime", escalationSolutionTime);
        modelAndView.addObject("createBy", createBy);
        modelAndView.addObject("priority", priority);
        modelAndView.addObject("customerID", customerID);
        modelAndView.addObject("responsibleID", responsibleID);
        modelAndView.addObject("realTillTimeNotUsed", realTillTimeNotUsed);
        modelAndView.addObject("escalationUpdateTime", escalationUpdateTime);
        modelAndView.addObject("escalationResponseTime", escalationResponseTime);
        modelAndView.addObject("typeID", typeID);
        modelAndView.addObject("archiveFlag", archiveFlag);
        modelAndView.addObject("untilTime", untilTime);
        modelAndView.addObject("priorityID", priorityID);
        modelAndView.addObject("getCreated", getCreated);
        modelAndView.addObject("queueID", queueID);
        modelAndView.addObject("ownerID", ownerID);
        modelAndView.addObject("escalationTime", escalationTime);
        modelAndView.addObject("owner", owner);
        modelAndView.addObject("slaid", slaid);
        modelAndView.addObject("unlockTimeout", unlockTimeout);
        modelAndView.addObject("getLockID", getLockID);
        modelAndView.addObject("customerUserID", customerUserID);
        modelAndView.addObject("stateID", stateID);
        modelAndView.addObject("groupID", groupID);
        modelAndView.addObject("timeUnit", timeUnit);
        modelAndView.addObject("serviceID", serviceID);
        modelAndView.addObject("lock", lock);
        modelAndView.addObject("state", state);
        modelAndView.addObject("type", type);
        modelAndView.addObject("responsible", responsible);
        modelAndView.addObject("changeBy", changeBy);
        modelAndView.addObject("stateType", stateType);
        modelAndView.addObject("queue", queue);
        modelAndView.addObject("changed", changed);
        modelAndView.addObject("ticketNumber", ticketNumber);
        modelAndView.addObject("title", title);
        modelAndView.addObject("age", age);
        modelAndView.addObject("ticketID", ticketID);

        return modelAndView;
    }
}