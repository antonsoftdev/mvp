package com.handyman.mvp.dto;

import com.handyman.mvp.model.User;

import java.util.Date;

public class LeadDtoRequest {

    private User user;

    private Date dateOfLead;

    private Date dateToWork;

    private String workContent;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateOfLead() {
        return dateOfLead;
    }

    public void setDateOfLead(Date dateOfLead) {
        this.dateOfLead = dateOfLead;
    }

    public Date getDateToWork() {
        return dateToWork;
    }

    public void setDateToWork(Date dateToWork) {
        this.dateToWork = dateToWork;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }
}
