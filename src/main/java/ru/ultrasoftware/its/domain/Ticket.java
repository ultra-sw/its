package ru.ultrasoftware.its.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pwmn on 14/11/2017.
 */


public class Ticket {

    @JsonProperty("UserLogin")
    private String userLogin;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("CustomerUser")
    private String customerUser;

    @JsonProperty("Queue")
    private String queue;

    @JsonProperty("State")
    private String state;

    @JsonProperty("Priority")
    private String priority;

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getCustomerUser() {
        return customerUser;
    }

    public void setCustomerUser(String customerUser) {
        this.customerUser = customerUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }


}
