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

        return new HashMap<Book, Integer>(inventory);
    }

    public void addBook(Book book) {
        int quantity = inventory.containsKey(book) ? inventory.get(book) : 0;
        inventory.put(book,quantity+1);
    }

    public boolean removeBook(Book book) {
        if(!inventory.containsKey(book) || inventory.get(book) == 0)
            return false;
        inventory.put(book, inventory.get(book)-1);
        return true;
    }
}
