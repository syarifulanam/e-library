package com.anam.elibrary.dto;

import java.util.Date;

// DTO = Data Transfer Object
// untuk ngisi data Form
public class CirculationDTO {
    private int bookId;
    private int memberId;
    private String requestDate;
    private String returnDate;
    private int lateFees; // DENDA PER HARI

    private int id;
    private String actualReturnDate;

    public CirculationDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getLateFees() {
        return lateFees;
    }

    public void setLateFees(int lateFees) {
        this.lateFees = lateFees;
    }

    public String getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(String actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
}
