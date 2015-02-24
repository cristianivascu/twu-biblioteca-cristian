package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Book> checkedOutBooks = new ArrayList<Book>();
    private Library library;

    public Customer(Library library){
        this.library = library;
    }

    public Message checkout(Book book) {
        if(library.removeItem(book)) {
            checkedOutBooks.add(book);
            return Message.SUCCESSFUL_CHECKOUT;
        }
        return Message.UNSUCCESSFUL_CHECKOUT;
    }

    public Message returnBook(Book book) {
        if(checkedOutBooks.contains(book) && library.addItem(book)){
            checkedOutBooks.remove(book);
            return Message.SUCCESSFUL_RETURN;
        }
        return Message.UNSUCCESSFUL_RETURN;
    }

    public List<Book> checkAvailableBooks() {
        return library.listAvailableItems();
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }
}
