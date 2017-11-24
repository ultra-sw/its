package ru.ultrasoftware.its.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pwmn on 14/11/2017.
 */
public class Article {
    @JsonProperty("Subject")
    private String subject;
    @JsonProperty("Body")
    private String body;
    @JsonProperty("ContentType")
    private String contentType;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

