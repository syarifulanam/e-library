package com.anam.elibrary.entity;

import java.util.Date;

public class Circulation {
    private int id;
    private String book;
    private String member;
    private Date requestDate;
    private Date returnDate;
    private int totalDays;
    private int actualReturnDate;
    private int lateDays;
    private int lateFees;
    private int totalLateFees;
}
