package ru.ultrasoftware.its.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtrsSession {



    @JsonProperty("SessionID")
    private String sessionId;



    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
