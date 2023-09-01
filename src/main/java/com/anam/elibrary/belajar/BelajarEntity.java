package com.anam.elibrary.belajar;

import com.anam.elibrary.entity.Book;

import java.util.Date;

public class BelajarEntity {
    public static void main(String[] args) {
        // cara isi data pakai constructor
        Book b = new Book(1, "JAVA BOOK", "FIRMAN", "2012", "B002", new Date(), new Date());

        // cara cetak data
        System.out.println(b.getYear());
        System.out.println(b.getBookCode());

        // Cara isi data ke dalam object Book
//        Book book = new Book(); // cara inisiasi sebuah object
//        book.setId(1);
//        book.setTitle("JAVA BOOK");
//        book.setYear("2022");

        // Cara cetak isi data dari object Book
//        int id = book.getId();
//        String title = book.getTitle();
//        System.out.println("id: " + id);
//        System.out.println("title: " + title);

//        System.out.println("id: " + book.getId());
//        System.out.println("title: " + book.getTitle());

//        System.out.println("tahun: " + book.getYear());


    }
}
