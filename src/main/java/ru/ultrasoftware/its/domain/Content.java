package ru.ultrasoftware.its.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Content {
    @JsonProperty("EscalationSolutionTime")
    private Integer escalationSolutionTime;
    @JsonProperty("CreateBy")
    private String createBy;
    @JsonProperty("Priority")
    private String priority;
    @JsonProperty("CustomerID")
    private String customerID;
    @JsonProperty("ResponsibleID")
    private Integer responsibleID;
    @JsonProperty("TicketID")
    private Integer ticketID;
    @JsonProperty("RealTillTimeNotUsed")
    private Integer realTillTimeNotUsed;
    @JsonProperty("EscalationUpdateTime")
    private Integer escalationUpdateTime;
    @JsonProperty("EscalationResponseTime")
    private Integer escalationResponseTime;
    @JsonProperty("TypeID")
    private Integer typeID;
    @JsonProperty("UntilTime")
    private String untilTime;
    @JsonProperty("PriorityID")
    private Integer priorityID;
    @JsonProperty("Created")
    private String created;
    @JsonProperty("QueueID")
    private Integer queueID;
    @JsonProperty("OwnerID")
    private Integer ownerID;
    @JsonProperty("ArchiveFlag")
    private String archiveFlag;
    @JsonProperty("EscalationTime")
    private String escalationTime;
    @JsonProperty("Owner")
    private String owner;
    @JsonProperty("SLAID")
    private String slaid;
    @JsonProperty("TimeUnit")
    private String timeUnit;
    @JsonProperty("LockID")
    private String lockID;
    @JsonProperty("CustomerUserID")
    private String customerUserID;
    @JsonProperty("StateID")
    private String stateID;
    @JsonProperty("GroupID")
    private String groupID;
    @JsonProperty("UnlockTimeout")
    private String unlockTimeout;
    @JsonProperty("ServiceID")
    private String serviceID;
    @JsonProperty("State")
    private String state;
    @JsonProperty("Lock")
    private String lock;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Responsible")
    private String responsible;
    @JsonProperty("ChangeBy")
    private String changeBy;
    @JsonProperty("StateType")
    private String stateType;
    @JsonProperty("Queue")
    private String queue;
    @JsonProperty("Changed")
    private String changed;
    @JsonProperty("TicketNumber")
    private String ticketNumber;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Age")
    private String age;

    public Integer getEscalationSolutionTime() {
        return escalationSolutionTime;
    }
    public String getCreateBy() {
        return createBy;
    }
    public String getPriority() {
        return priority;
    }
    public String getCustomerID() {return customerID;}
    public Integer getResponsibleID() {
        return responsibleID;
    }
    public Integer getRealTillTimeNotUsed() {
        return realTillTimeNotUsed;
    }
    public Integer getEscalationUpdateTime() {
        return escalationUpdateTime;
    }
    public Integer getEscalationResponseTime() {
        return escalationResponseTime;
    }
    public Integer getTypeID() {
        return typeID;
    }
    public String getArchiveFlag() {
        return archiveFlag;
    }
    public String getUntilTime() {
        return untilTime;
    }
    public Integer getPriorityID() {
        return priorityID;
    }
    public String getCreated() {
        return created;
    }
    public Integer getQueueID() {
        return queueID;
    }
    public Integer getOwnerID() {
        return ownerID;
    }
    public String geEscalationTime() {
        return escalationTime;
    }
    public String getOwner() {
        return owner;
    }
    public String getSLAID() {
        return slaid;
    }
    public String getUnlockTimeout() {
        return unlockTimeout;
    }
    public String getLockID() {
        return lockID;
    }
    public String getCustomerUserID() { return customerUserID; }
    public String getStateID() {
        return stateID;
    }
    public String getGroupID() {
        return groupID;
    }
    public String getTimeUnit() {
        return timeUnit;
    }
    public String getServiceID() {
        return serviceID;
    }
    public String getLock() {
        return lock;
    }
    public String getState() {
        return state;
    }
    public String getType() {
        return type;
    }
    public String getResponsible() {
        return responsible;
    }
    public String getChangeBy() {
        return changeBy;
    }
    public String getStateType() {
        return stateType;
    }
    public String getQueue() {
        return queue;
    }
    public String getChanged() {
        return changed;
    }
    public String getTicketNumber() {
        return ticketNumber;
    }
    public String getTitle() {
        return title;
    }
    public String getAge() {
        return age;
    }
    public Integer getTicketID() {
        return ticketID;
    }

}
