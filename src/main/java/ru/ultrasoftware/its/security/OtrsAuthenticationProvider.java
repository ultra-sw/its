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

import java.util.ArrayList;
import java.util.Collection;

@Component
public class OtrsAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        //TODO get session id from otrs
        UriComponents uri = UriComponentsBuilder
                .fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Session")
                .queryParam("UserLogin", username)
                .queryParam("Password", password)
                .build();
        UriComponents tic = UriComponentsBuilder
        		.fromHttpUrl("http://it.nvrs.net:7777/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorREST/Ticket")
        		.queryParam("UserLogin", username)
                .queryParam("Password", password)
        		.build();
        		
        String urlString = uri.toUriString();
        String urlTicket = tic.toUriString();
		System.out.println(urlString);
		System.out.println(urlTicket);
		RestTemplate restTemplate = new RestTemplate();
		
		OtrsSession result = restTemplate.postForObject(urlString, null, OtrsSession.class);
		OtrsTickets tickets = restTemplate.getForObject(urlTicket, OtrsTickets.class);
		System.out.println(result.getSessionId());
		
   /*     if (!("1".equals(username) && "1".equals(password))) {
            throw new BadCredentialsException("Incorrect username or password.");
        }
*/for (int i = 0; i<tickets.ticketNumber(); i++)
	System.out.println(tickets.getTicket(i));

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
