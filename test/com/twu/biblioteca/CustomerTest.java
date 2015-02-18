package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTest {

    private Customer alice;
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
        alice = new Customer(bangaloreLibrary);
    }

    @Test
    public void testSuccessfulCheckout(){
        assertTrue(alice.checkout(harryPotter1));
        assertTrue(alice.getCheckedOutBooks().contains(harryPotter1));
    }

    @Test
    public void testUnsuccessfulCheckout(){
        assertFalse(alice.checkout(harryPotter2));
        assertFalse(alice.getCheckedOutBooks().contains(harryPotter2));
    }

}
