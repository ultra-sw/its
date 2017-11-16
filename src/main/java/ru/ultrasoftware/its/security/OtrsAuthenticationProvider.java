package ru.ultrasoftware.its.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.ultrasoftware.its.bean.SessionID;
import ru.ultrasoftware.its.bean.SessionID_Config;
import ru.ultrasoftware.its.controller.IndexController;
import ru.ultrasoftware.its.domain.OtrsSession;
import ru.ultrasoftware.its.domain.OtrsTickets;
import ru.ultrasoftware.its.domain.OtrsUserInfo;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

@Component

public class OtrsAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        IndexController.agent = true;
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        //TODO get session id from otrs1
        UriComponents uri = UriComponentsBuilder
                .fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Session")
                .queryParam("UserLogin", username)
                .queryParam("Password", password)
                .build();
        String urlString = uri.toUriString();
        RestTemplate restTemplate = new RestTemplate();
        OtrsSession sessionID = restTemplate.postForObject(urlString, null, OtrsSession.class);

        if(sessionID.getSessionId()==null){
            uri = UriComponentsBuilder
                    .fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Session")
                    .queryParam("CustomerUserLogin", username)
                    .queryParam("Password", password)
                    .build();
            urlString = uri.toUriString();
            sessionID = restTemplate.postForObject(urlString, null, OtrsSession.class);
            IndexController.agent = false;
        }
        IndexController.sessionID = sessionID.getSessionId();


        if (sessionID.getSessionId()==null) {
            throw new BadCredentialsException("Incorrect username or password.");
        }
        else{

            String url = "http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Session/" + sessionID.getSessionId();
            OtrsUserInfo userInfo = restTemplate.getForObject(url, OtrsUserInfo.class);

            System.out.println(userInfo.getsessionData()); // Получение листа информации о сессии

        }

        //TODO callSESSION



       UriComponents tic = UriComponentsBuilder
        		.fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket")
        		.queryParam("SessionID", sessionID.getSessionId())
        		.build();
        		

        String urlTicket = tic.toUriString();
		System.out.println(sessionID.getSessionId());
		OtrsTickets tickets = restTemplate.getForObject(urlTicket, OtrsTickets.class);
        System.out.println(tickets.getTickets());
        System.out.println();
      //  System.out.println(sessionID.getSessionId());

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        if(IndexController.agent == true){
        authorities.add(new SimpleGrantedAuthority("ROLE_AGENT"));}
        else
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        }
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
