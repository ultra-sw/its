package ru.ultrasoftware.its.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtrsUserTickets {

    @JsonProperty("TicketID")
    private List<Integer> ticketIds = new ArrayList<Integer>();

    public List<Integer> getTicketIds() {
        return ticketIds;
    }

}
