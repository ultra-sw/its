package ru.ultrasoftware.its.domain; 

import java.util.List; 

import com.fasterxml.jackson.annotation.JsonProperty; 

public class OtrsTickets { 

@JsonProperty("TicketID") 
private List ticket; 

public Object getTicket(int i) { 
return ticket.get(i); 
} 

public int ticketNumber() { ; 
return ticket.size(); 
} 
 
}