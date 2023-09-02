package com.anam.elibrary.entity;

import java.util.Date;

public class Circulation {
    private int id;
    private String book;
    private String member;
    private Date startDate;
    private Date endDate;
    private Date returnDate;
    private Date delayDate;
    private int charge;

    public Circulation() {
    }

    public Circulation(int id, String book, String member, Date startDate, Date endDate, Date returnDate, Date delayDate, int charge) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
        this.delayDate = delayDate;
        this.charge = charge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getDelayDate() {
        return delayDate;
    }

    public void setDelayDate(Date delayDate) {
        this.delayDate = delayDate;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }
}

