package ru.ultrasoftware.its.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtrsUserInfo {

    @JsonProperty("SessionData")
    private List sessionData;
    public Object getsessionData(int i) {
        return sessionData.get(i);
    }

    public int sessionDataSize() { ;
        return sessionData.size();
    }

}