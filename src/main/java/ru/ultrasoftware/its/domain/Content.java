package ru.ultrasoftware.its.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Content {
    @JsonProperty("EscalationSolutionTime")
    private Integer EscalationSolutionTime;
    @JsonProperty("CreateBy")
    private String CreateBy;
    @JsonProperty("Priority")
    private String Priority;
    @JsonProperty("CustomerID")
    private Integer CustomerID;
    @JsonProperty("ResponsibleID")
    private Integer ResponsibleID;
    @JsonProperty("TicketID")
    private Integer TicketID;
    @JsonProperty("RealTillTimeNotUsed")
    private Integer RealTillTimeNotUsed;
    @JsonProperty("EscalationUpdateTime")
    private Integer EscalationUpdateTime;
    @JsonProperty("EscalationResponseTime")
    private Integer EscalationResponseTime;
    @JsonProperty("TypeID")
    private Integer TypeID;
    @JsonProperty("UntilTime")
    private String UntilTime;
    @JsonProperty("PriorityID")
    private Integer PriorityID;
    @JsonProperty("Created")
    private String Created;
    @JsonProperty("QueueID")
    private Integer QueueID;
    @JsonProperty("OwnerID")
    private Integer OwnerID;
    @JsonProperty("ArchiveFlag")
    private String ArchiveFlag;
    @JsonProperty("EscalationTime")
    private String EscalationTime;
    @JsonProperty("Owner")
    private String Owner;
    @JsonProperty("SLAID")
    private String SLAID;
    @JsonProperty("TimeUnit")
    private String TimeUnit;
    @JsonProperty("LockID")
    private String LockID;
    @JsonProperty("CustomerUserID")
    private String CustomerUserID;
    @JsonProperty("StateID")
    private String StateID;
    @JsonProperty("GroupID")
    private String GroupID;
    @JsonProperty("UnlockTimeout")
    private String UnlockTimeout;
    @JsonProperty("ServiceID")
    private String ServiceID;
    @JsonProperty("State")
    private String State;
    @JsonProperty("Lock")
    private String Lock;
    @JsonProperty("Type")
    private String Type;
    @JsonProperty("Responsible")
    private String Responsible;
    @JsonProperty("ChangeBy")
    private String ChangeBy;
    @JsonProperty("StateType")
    private String StateType;
    @JsonProperty("Queue")
    private String Queue;
    @JsonProperty("Changed")
    private String Changed;
    @JsonProperty("TicketNumber")
    private String TicketNumber;
    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Age")
    private String Age;

    public Integer getEscalationSolutionTime() {
        return EscalationSolutionTime;
    }
    public String getCreateBy() {
        return CreateBy;
    }
    public String getPriority() {
        return Priority;
    }
    public Integer getCustomerID() {
        return CustomerID;
    }
    public Integer getResponsibleID() {
        return ResponsibleID;
    }
    public Integer getRealTillTimeNotUsed() {
        return RealTillTimeNotUsed;
    }
    public Integer getEscalationUpdateTime() {
        return EscalationUpdateTime;
    }
    public Integer getEscalationResponseTime() {
        return EscalationResponseTime;
    }
    public Integer getTypeID() {
        return TypeID;
    }
    public String getArchiveFlag() {
        return ArchiveFlag;
    }
    public String getUntilTime() {
        return UntilTime;
    }
    public Integer getPriorityID() {
        return PriorityID;
    }
    public String getCreated() {
        return Created;
    }
    public Integer getQueueID() {
        return QueueID;
    }
    public Integer getOwnerID() {
        return OwnerID;
    }
    public String geEscalationTime() {
        return EscalationTime;
    }
    public String getOwner() {
        return Owner;
    }
    public String getSLAID() {
        return SLAID;
    }
    public String getUnlockTimeout() {
        return UnlockTimeout;
    }
    public String getLockID() {
        return LockID;
    }
    public String getCustomerUserID() {
        return CustomerUserID;
    }
    public String getStateID() {
        return StateID;
    }
    public String getGroupID() {
        return GroupID;
    }
    public String getTimeUnit() {
        return TimeUnit;
    }
    public String getServiceID() {
        return ServiceID;
    }
    public String getLock() {
        return Lock;
    }
    public String getState() {
        return State;
    }
    public String getType() {
        return Type;
    }
    public String getResponsible() {
        return Responsible;
    }
    public String getChangeBy() {
        return ChangeBy;
    }
    public String getStateType() {
        return StateType;
    }
    public String getQueue() {
        return Queue;
    }
    public String getChanged() {
        return Changed;
    }
    public String getTicketNumber() {
        return TicketNumber;
    }
    public String getTitle() {
        return Title;
    }
    public String getAge() {
        return Age;
    }
    public Integer getTicketID() {
        return TicketID;
    }

}
