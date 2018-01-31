package ru.ultrasoftware.its.security;

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
import ru.ultrasoftware.its.controller.IndexController;
import ru.ultrasoftware.its.domain.OtrsSession;
import ru.ultrasoftware.its.domain.OtrsUserTickets;
import ru.ultrasoftware.its.domain.OtrsUserInfo;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class OtrsAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        boolean roleAgent = true;
        int agentID=0;
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        OtrsUserInfo userInfo;
        //TODO get session id from otrs1
        UriComponents uri = UriComponentsBuilder
                .fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Session")
                .queryParam("UserLogin", username)
                .queryParam("Password", password)
                .build();
        String urlString = uri.toUriString();
        RestTemplate restTemplate = new RestTemplate();
        OtrsSession otrsSession = restTemplate.postForObject(urlString, null, OtrsSession.class);

        if(otrsSession.getSessionId()==null){
            uri = UriComponentsBuilder
                    .fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Session")
                    .queryParam("CustomerUserLogin", username)
                    .queryParam("Password", password)
                    .build();
            urlString = uri.toUriString();
            otrsSession = restTemplate.postForObject(urlString, null, OtrsSession.class);
            roleAgent = false;
        }

        if (otrsSession.getSessionId()==null) {
            throw new BadCredentialsException("Incorrect username or password.");
        }
        else{

            String url = "http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Session/" + otrsSession.getSessionId();
            userInfo = restTemplate.getForObject(url, OtrsUserInfo.class);
            System.out.print(userInfo.getSessionDataMap());

        }

        //TODO callSESSION



       UriComponents tic = UriComponentsBuilder
        		.fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket")
        		.queryParam("SessionID", otrsSession.getSessionId())
        		.build();
        		

        String urlTicket = tic.toUriString();
		System.out.println(otrsSession.getSessionId());
		OtrsUserTickets tickets = restTemplate.getForObject(urlTicket, OtrsUserTickets.class);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
       
        if(roleAgent == true) {
            authorities.add(new SimpleGrantedAuthority("ROLE_AGENT"));
            agentID = userInfo.getAgentID();
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        }
        System.out.println(otrsSession.getSessionId());
        return new UsernamePasswordAuthenticationToken(new OtrsAuthenticationInfo(otrsSession.getSessionId(),
                username, roleAgent, agentID), authentication.getCredentials(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
