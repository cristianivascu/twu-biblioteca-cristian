package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library<Book> bangaloreLibrary;
    private Book harryPotter1;
    private Book harryPotter2;
    private Map<Book, Integer> inventory = new HashMap<Book, Integer>();

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        inventory.put(harryPotter1, 1);
        bangaloreLibrary = new Library<Book>(inventory);
    }

    @Test
    public void shouldAddBookToInventory() {
        bangaloreLibrary.addItem(harryPotter2);
        assertEquals(1, (int) bangaloreLibrary.getInventory().get(harryPotter2));
    }

    @Test
    public void shouldNotAddNullToInventory() {
        assertFalse(bangaloreLibrary.addItem(null));
    }

    @Test
    public void shouldRemoveAvailableBookFromInventory() {
        assertTrue(bangaloreLibrary.removeItem(harryPotter1));
        assertEquals(0, (int) bangaloreLibrary.getInventory().get(harryPotter1));
        assertFalse(bangaloreLibrary.removeItem(harryPotter1));
        assertFalse(bangaloreLibrary.removeItem(harryPotter2));
    }

    @Test
    public void shouldListAvailableBooks(){
        bangaloreLibrary.addItem(harryPotter2);
        assertEquals(2, bangaloreLibrary.listAvailableItems().size());
        assertTrue(bangaloreLibrary.listAvailableItems().contains(harryPotter1));
        assertTrue(bangaloreLibrary.listAvailableItems().contains(harryPotter2));
        bangaloreLibrary.removeItem(harryPotter1);
        assertEquals(1, bangaloreLibrary.listAvailableItems().size());
        assertTrue(bangaloreLibrary.listAvailableItems().contains(harryPotter2));
        assertEquals(2, bangaloreLibrary.getInventory().size());
    }
}
