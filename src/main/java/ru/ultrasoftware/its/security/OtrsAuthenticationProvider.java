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
import ru.ultrasoftware.its.domain.OtrsSession;
import ru.ultrasoftware.its.domain.OtrsTickets;
import ru.ultrasoftware.its.domain.OtrsUserInfo;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class OtrsAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        boolean ROLE_AGENT = true;
        //TODO get session id from otrs
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
            ROLE_AGENT = false;
        }

        if (sessionID.getSessionId()==null) {
            throw new BadCredentialsException("Incorrect username or password.");
        }
        else{
            String url = "http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Session/" + sessionID.getSessionId();
            OtrsUserInfo userInfo = restTemplate.getForObject(url, OtrsUserInfo.class);
           /* for (int i = 0; i<userInfo.sessionDataSize(); i++)
               System.out.println(userInfo.getsessionData(i)); - Вывод массива SessionData*/

        }

        //TODO callSESSION

      /*  String userURL = "http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Session/" + sessionID.getSessionId();
        System.out.println(userURL);*/

       UriComponents tic = UriComponentsBuilder
        		.fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket")
        		.queryParam("UserLogin", username)
                .queryParam("Password", password)
        		.build();
        		

        String urlTicket = tic.toUriString();
		System.out.println(sessionID.getSessionId());
		OtrsTickets tickets = restTemplate.getForObject(urlTicket, OtrsTickets.class);

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        if(ROLE_AGENT == true){
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
