package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
public class BookTest {

    private Book harryPotter1;
    private Book harryPotter1Sample2;
    Library bangaloreLibrary;
    private Map<Book, Integer> inventory = new HashMap<Book, Integer>();

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter1Sample2 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        inventory.put(harryPotter1,1);
        bangaloreLibrary = new Library(inventory);
    }

    @Test
    public void testEquality(){
        assertEquals(harryPotter1, harryPotter1Sample2);
    }

    @Test
    public void testEqualityWithinStandardMap(){
        HashMap<Book, Integer> testMap = new HashMap<Book, Integer>();
        testMap.put(harryPotter1,1);
        testMap.put(harryPotter1Sample2,1);
        assertEquals(1, testMap.size());
    }

    @Test
    public void testEqualityWithinLibrary(){
        bangaloreLibrary.addBook(harryPotter1);
        bangaloreLibrary.addBook(harryPotter1Sample2);
        assertEquals(3, (int) bangaloreLibrary.getInventory().get(harryPotter1));
        assertEquals(3, (int) bangaloreLibrary.getInventory().get(harryPotter1Sample2));
        assertEquals(1,  bangaloreLibrary.getInventory().size());

    }

}
