package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<Book, Integer> inventory;

    public Library(Map<Book, Integer> inventory) {
        //defensive copying, only Library should manage the inventory
        this.inventory = new HashMap<Book, Integer>(inventory);
    }

    public Map<Book, Integer> getInventory() {
        return inventory;
    }

    public boolean addBook(Book book) {
        if(!inventory.containsKey(book))
            return false;
        inventory.put(book,inventory.get(book)+1);
        return true;
    }

    public boolean removeBook(Book book) {
        if(!inventory.containsKey(book) || inventory.get(book) == 0)
            return false;
        inventory.put(book, inventory.get(book)-1);
        return true;
    }
}
