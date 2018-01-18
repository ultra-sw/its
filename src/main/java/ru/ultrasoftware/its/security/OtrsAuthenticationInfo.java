package ru.ultrasoftware.its.security;

import java.security.Principal;

public class OtrsAuthenticationInfo implements Principal {

    private String sessionId;
    private String name;
    private boolean roleAgent;

    public OtrsAuthenticationInfo(String sessionId, String name, boolean roleAgent) {
        this.sessionId = sessionId;
        this.name = name;
        this.roleAgent = roleAgent;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getSessionId() {
        return sessionId;
    }
    public boolean getRoleAgent() {
        return roleAgent;
    }
}
