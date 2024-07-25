package com.handyman.mvp.dto;

import com.handyman.mvp.model.User;

import java.util.Date;

public class LeadDtoResponse {

    private long id;

    private User user;

    private User worker;

    private Date dateOfLead;

    private Date dateToWork;

    private String workContent;

    private String price;

    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getWorker() {
        return worker;
    }

    public void setWorker(User worker) {
        this.worker = worker;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
