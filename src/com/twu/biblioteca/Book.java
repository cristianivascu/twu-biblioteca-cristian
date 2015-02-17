package com.twu.biblioteca;

/**
 * Created by cristianivascu on 17/02/2015.
 */
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
