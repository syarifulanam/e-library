package com.anam.elibrary.entity;

import java.util.Date;

public class Circulation {
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private int bookId;
    private int memberId;
    private Date requestDate;
    private Date returnDate;
    private int days;
    private Date actualReturnDate;
    private int lateDays;
    private int lateFees; // DENDA PER HARI
    private int totalLateFees; // TOTAL DENDA
    private String status; // IN PROGRESS, FINISHED, CANCELED

    private String bookCode;
    private String bookTitle;
    private String memberCode;
    private String memberName;

    public Circulation() {
    }

    public Circulation(int id, Date createdAt, Date updatedAt, int bookId, int memberId, Date requestDate,
                       Date returnDate, int days, Date actualReturnDate, int lateDays, int lateFees, int totalLateFees,
                       String status) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.bookId = bookId;
        this.memberId = memberId;
        this.requestDate = requestDate;
        this.returnDate = returnDate;
        this.days = days;
        this.actualReturnDate = actualReturnDate;
        this.lateDays = lateDays;
        this.lateFees = lateFees;
        this.totalLateFees = totalLateFees;
        this.status = status;
    }

    // constructor untuk menampilkan data findAll
    public Circulation(int id, String bookCode, String bookTitle, String memberCode, String memberName,
                       Date requestDate, Date returnDate, int days, Date actualReturnDate, int lateDays,
                       int lateFees, int totalLateFees, String status) {
        this.id = id;
        this.bookCode = bookCode;
        this.bookTitle = bookTitle;
        this.memberCode = memberCode;
        this.memberName = memberName;
        this.requestDate = requestDate;
        this.returnDate = returnDate;
        this.days = days;
        this.actualReturnDate = actualReturnDate;
        this.lateDays = lateDays;
        this.lateFees = lateFees;
        this.totalLateFees = totalLateFees;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public int getLateDays() {
        return lateDays;
    }

    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }

    public int getLateFees() {
        return lateFees;
    }

    public void setLateFees(int lateFees) {
        this.lateFees = lateFees;
    }

    public int getTotalLateFees() {
        return totalLateFees;
    }

    public void setTotalLateFees(int totalLateFees) {
        this.totalLateFees = totalLateFees;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
