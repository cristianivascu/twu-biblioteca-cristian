package com.twu.biblioteca;

public class Book {

    private final String author;
    private final String title;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
