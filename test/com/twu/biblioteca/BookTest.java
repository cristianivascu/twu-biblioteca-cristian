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
    private Inventory<Book> bangaloreInventory;
    private Map<Book, Integer> inventory = new HashMap<Book, Integer>();

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter1Copy = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        inventory.put(harryPotter1,1);
        inventory.put(harryPotter2,1);
        bangaloreInventory = new Inventory<Book>(inventory);
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
        assertEquals(1, (int) bangaloreInventory.getItems().get(harryPotter1));
        bangaloreInventory.addItem(harryPotter1);
        bangaloreInventory.addItem(harryPotter1Copy);
        assertEquals(3, (int) bangaloreInventory.getItems().get(harryPotter1));
        assertEquals(3, (int) bangaloreInventory.getItems().get(harryPotter1Copy));
        assertEquals(1, (int) bangaloreInventory.getItems().get(harryPotter2));
        assertEquals(2,  bangaloreInventory.getItems().size());

    }


}
