package ru.ultrasoftware.its.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketInfo {

    @JsonProperty("Ticket")
    private List<Content> ticketInf;


    public List<Content> getTicketInf() {
        return ticketInf;
    }

}
