package com.anam.elibrary.belajar;

import com.anam.elibrary.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BelajarListDataType {
    public static void main(String[] args) {
//        String student = "Firman"; // variable ini hanya bisa menampung 1 data
//        System.out.println(student);
//
//        String[] students = {"firman", "anam", "putri"}; // 0, 1, 2 -> cara inisiasi array
//        System.out.println(students[1]);

        // DATA BUKU ke 1
        Book bukuNo1 = new Book();
        bukuNo1.setId(1);
        bukuNo1.setTitle("Java Book");
        bukuNo1.setYear("2012");
        bukuNo1.setPublisher("Ria Busana");

        // DATA BUKU ke 2
        Book bukuNo2 = new Book();
        bukuNo2.setId(2);
        bukuNo2.setTitle("HTML Book");
        bukuNo2.setYear("2011");
        bukuNo2.setPublisher("APPLE");

        // untuk menyimpan banyak data Book ke dalam List / Arraylist
        List<Book> bookList = new ArrayList<>(); // cara inisiasi array list
        bookList.add(bukuNo1); // cara simpan data ke 1 / index 0
        bookList.add(bukuNo2); // cara simpan data ke 2 / index 1

        // cata menampilan data buku ke 2
        Book bookIndexKe1 = bookList.get(1);
        System.out.println("ID: " + bookIndexKe1.getId());
        System.out.println("TITLE: " + bookIndexKe1.getTitle());
        System.out.println("YEAR: " + bookIndexKe1.getYear());

        // cara untuk menampilan data dengan FOR
//        for (int i = 0; i < bookList.size(); i++) {
//            System.out.println("ID: " + bookList.get(i).getId());
//            System.out.println("TITLE: " + bookList.get(i).getTitle());
//            System.out.println("YEAR: " + bookList.get(i).getYear());
//            System.out.println(); // biar ada spasi ke bawah
//        }
    }
}
