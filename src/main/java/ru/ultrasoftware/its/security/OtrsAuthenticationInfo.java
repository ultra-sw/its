package ru.ultrasoftware.its.security;

import java.security.Principal;

public class OtrsAuthenticationInfo implements Principal {

    private String sessionId;
    private String name;
    private boolean roleAgent;
    private int agentID;
    public OtrsAuthenticationInfo(String sessionId, String name, boolean roleAgent, int agentID) {
        this.sessionId = sessionId;
        this.name = name;
        this.roleAgent = roleAgent;
        this.agentID = agentID;

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
    public int getAgentID() {
        return agentID;
    }
}
