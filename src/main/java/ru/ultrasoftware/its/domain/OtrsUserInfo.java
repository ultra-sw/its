package ru.ultrasoftware.its.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtrsUserInfo {

    @JsonProperty("SessionData")
    private List<SessionDataItem> sessionData;
    private Map<String, String> sessionDataMap;

    public List<SessionDataItem> getSessionData() {
        return sessionData;
    }

    public void setSessionData(List<SessionDataItem> sessionData) {
        this.sessionData = sessionData;
        sessionDataMap = new HashMap<>(sessionData.size());
        for(SessionDataItem item : sessionData) {
            sessionDataMap.put(item.getKey(), item.getValue());
        }
    }

    public Map<String, String> getSessionDataMap() {
        return sessionDataMap;
    }
}
