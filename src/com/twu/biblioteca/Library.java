package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristianivascu on 17/02/2015.
 */
public class Library {

    private List<Book> inventory;

    public Library(List<Book> inventory) {
        //defensive copying
        this.inventory = new ArrayList<Book>(inventory);
    }

    public List<Book> getInventory() {
        return inventory;
    }

    public void addBook(Book book) {
        inventory.add(book);
    }

    public boolean removeBook(Book book) {
        return inventory.remove(book);
    }
}
