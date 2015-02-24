package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory<Book> bangaloreInventory;
    private Book harryPotter1;
    private Book harryPotter2;
    private Map<Book, Integer> inventory = new HashMap<Book, Integer>();

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        inventory.put(harryPotter1, 1);
        bangaloreInventory = new Inventory<Book>(inventory);
    }

    @Test
    public void shouldAddBookToInventory() {
        bangaloreInventory.addItem(harryPotter2);
        assertEquals(1, (int) bangaloreInventory.getItems().get(harryPotter2));
    }

    @Test
    public void shouldNotAddNullToInventory() {
        assertFalse(bangaloreInventory.addItem(null));
    }

    @Test
    public void shouldRemoveAvailableBookFromInventory() {
        assertTrue(bangaloreInventory.removeItem(harryPotter1));
        assertEquals(0, (int) bangaloreInventory.getItems().get(harryPotter1));
        assertFalse(bangaloreInventory.removeItem(harryPotter1));
        assertFalse(bangaloreInventory.removeItem(harryPotter2));
    }

    @Test
    public void shouldListAvailableBooks(){
        bangaloreInventory.addItem(harryPotter2);
        assertEquals(2, bangaloreInventory.listAvailableItems().size());
        assertTrue(bangaloreInventory.listAvailableItems().contains(harryPotter1));
        assertTrue(bangaloreInventory.listAvailableItems().contains(harryPotter2));
        bangaloreInventory.removeItem(harryPotter1);
        assertEquals(1, bangaloreInventory.listAvailableItems().size());
        assertTrue(bangaloreInventory.listAvailableItems().contains(harryPotter2));
        assertEquals(2, bangaloreInventory.getItems().size());
    }
}
