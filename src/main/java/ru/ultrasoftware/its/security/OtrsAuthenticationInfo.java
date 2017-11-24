package ru.ultrasoftware.its.security;

import java.security.Principal;

public class OtrsAuthenticationInfo implements Principal {

    private String sessionId;
    private String name;

    public OtrsAuthenticationInfo(String sessionId, String name) {
        this.sessionId = sessionId;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getSessionId() {
        return sessionId;
    }
}
