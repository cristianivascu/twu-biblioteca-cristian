package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTest {

    private Customer alice;
    private Book harryPotter1;
    private Book harryPotter2;
    private Map<Book, Integer> inventory = new HashMap<Book, Integer>();

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        inventory.put(harryPotter1,1);
        Library bangaloreLibrary = new Library(inventory);
        alice = new Customer(bangaloreLibrary);
    }

    @Test
    public void shouldCheckoutAvailableBook(){
        assertTrue(alice.checkout(harryPotter1));
        assertTrue(alice.getCheckedOutBooks().contains(harryPotter1));
        assertFalse(alice.checkout(harryPotter2));
    }

    @Test
    public void shouldReturnCheckedOutBook(){
        alice.checkout(harryPotter1);
        assertTrue(alice.returnBook(harryPotter1));
        assertFalse(alice.getCheckedOutBooks().contains(harryPotter1));
        assertFalse(alice.returnBook(harryPotter2));
    }

}
