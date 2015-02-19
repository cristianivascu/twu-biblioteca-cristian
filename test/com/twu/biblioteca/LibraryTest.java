package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library bangaloreLibrary;
    private Book harryPotter1;
    private Book harryPotter2;
    private Map<Book, Integer> inventory = new HashMap<Book, Integer>();

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        inventory.put(harryPotter1, 1);
        bangaloreLibrary = new Library(inventory);
    }

    @Test
    public void testAddBookToInventory() {
        bangaloreLibrary.addBook(harryPotter2);
        assertEquals(1, (int) bangaloreLibrary.getInventory().get(harryPotter2));
    }

    @Test
    public void testRemoveAvailableBookFromInventory() {
        assertTrue(bangaloreLibrary.removeBook(harryPotter1));
        assertEquals(0, (int) bangaloreLibrary.getInventory().get(harryPotter1));
        assertFalse(bangaloreLibrary.removeBook(harryPotter1));
        assertFalse(bangaloreLibrary.removeBook(harryPotter2));
    }

    @Test
    public void shouldListAvailableBooks(){
        bangaloreLibrary.addBook(harryPotter2);
        assertEquals(2, bangaloreLibrary.listAvailableBooks().size());
        assertTrue(bangaloreLibrary.listAvailableBooks().contains(harryPotter1));
        assertTrue(bangaloreLibrary.listAvailableBooks().contains(harryPotter2));
        bangaloreLibrary.removeBook(harryPotter1);
        assertEquals(1, bangaloreLibrary.listAvailableBooks().size());
        assertTrue(bangaloreLibrary.listAvailableBooks().contains(harryPotter2));
        assertEquals(2, bangaloreLibrary.getInventory().size());
    }
}
