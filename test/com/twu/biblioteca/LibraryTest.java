package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library bangaloreLibrary;
    private Book harryPotter1;
    private Book harryPotter2;
    private List<Book> inventory = new ArrayList<Book>();

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        inventory.add(harryPotter1);
        bangaloreLibrary = new Library(inventory);
    }

    @Test
    public void testAddBookToInventory() {
        bangaloreLibrary.addBook(harryPotter2);
        assertTrue(bangaloreLibrary.getInventory().contains(harryPotter2));
    }

    @Test
    public void testRemoveAvailableBookFromInventory() {
        assertTrue(bangaloreLibrary.removeBook(harryPotter1));
        assertFalse(bangaloreLibrary.getInventory().contains(harryPotter1));
        assertFalse(bangaloreLibrary.removeBook(harryPotter2));
    }
}
