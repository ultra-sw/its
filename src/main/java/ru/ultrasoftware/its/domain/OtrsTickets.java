package ru.ultrasoftware.its.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtrsTickets {

    @JsonProperty("TicketID")
    private List tickets;

    public List getTickets() {
        return tickets;
    }

}