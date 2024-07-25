package com.handyman.mvp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "LEADS")
public class Lead {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WORKER_ID", nullable = false)
    private User worker;

    @Column(name = "DATE_OF_LEAD", nullable = false)
    private String dateOfLead;

    @Column(name = "DATE_TO_WORK", nullable = false)
    private String dateToWork;

    @Column(name = "WORK_CONTENT", nullable = false)
    private String workContent;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "FEEDBACK_FROM_USER", nullable = false)
    private String feedFromUser;

    @Column(name = "FEEDBACK_FROM_WORKER", nullable = false)
    private String feedFromWorker;

    @Column(name = "STATUS", nullable = false)
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

    public String getDateOfLead() {
        return dateOfLead;
    }

    public void setDateOfLead(String dateOfLead) {
        this.dateOfLead = dateOfLead;
    }

    public String getDateToWork() {
        return dateToWork;
    }

    public void setDateToWork(String dateToWork) {
        this.dateToWork = dateToWork;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getFeedFromUser() {
        return feedFromUser;
    }

    public void setFeedFromUser(String feedFromUser) {
        this.feedFromUser = feedFromUser;
    }

    public String getFeedFromWorker() {
        return feedFromWorker;
    }

    public void setFeedFromWorker(String feedFromWorker) {
        this.feedFromWorker = feedFromWorker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
