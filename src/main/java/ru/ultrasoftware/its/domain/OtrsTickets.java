package ru.ultrasoftware.its.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtrsTickets {

	@JsonProperty("TicketID")
	private String[] ticket;
	
	public String getTicket(int i) {	
        return ticket[i];
    }

	public int ticketNumber() {
		return ticket.length;
	}
	
    public void setTicket(String[] ticket) {
        this.ticket = ticket;
    }

}
