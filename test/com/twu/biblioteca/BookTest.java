package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
public class BookTest {

    private Book harryPotter1;
    private Book harryPotter1Copy;
    private Book harryPotter2;
    private Library<Book> bangaloreLibrary;
    private Map<Book, Integer> inventory = new HashMap<Book, Integer>();

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter1Copy = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        inventory.put(harryPotter1,1);
        inventory.put(harryPotter2,1);
        bangaloreLibrary = new Library<Book>(inventory);
    }

    @Test
    public void shouldConsiderEqualBooksWithSameFields(){
        assertEquals(harryPotter1, harryPotter1Copy);
    }

    @Test
    public void ensureCorrectBehaviourInStandardMap(){
        HashMap<Book, Integer> testMap = new HashMap<Book, Integer>();
        testMap.put(harryPotter1,1);
        testMap.put(harryPotter1Copy,1);
        assertEquals(1, testMap.size());
    }

    @Test
    public void ensureCorrectBehaviourInLibrary(){
        assertEquals(1, (int) bangaloreLibrary.getInventory().get(harryPotter1));
        bangaloreLibrary.addItem(harryPotter1);
        bangaloreLibrary.addItem(harryPotter1Copy);
        assertEquals(3, (int) bangaloreLibrary.getInventory().get(harryPotter1));
        assertEquals(3, (int) bangaloreLibrary.getInventory().get(harryPotter1Copy));
        assertEquals(1, (int) bangaloreLibrary.getInventory().get(harryPotter2));
        assertEquals(2,  bangaloreLibrary.getInventory().size());

    }


}
