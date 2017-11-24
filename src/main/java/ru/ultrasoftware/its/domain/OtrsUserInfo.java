package ru.ultrasoftware.its.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtrsUserInfo {

    @JsonProperty("SessionData")
    private List sessionData;

    public Object getsessionData() {
        return sessionData;
    }

}