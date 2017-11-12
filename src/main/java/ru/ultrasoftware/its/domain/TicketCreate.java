package ru.ultrasoftware.its.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pwmn on 10/11/2017.
 */
public class TicketCreateTitle {

    @JsonProperty("title")
    private String title;

    @JsonAnyGetter
    public String getTitle() {
        return title;
    }
    @JsonAnySetter
    public void setTitle(String title) {
        this.title = title;
    }


}
