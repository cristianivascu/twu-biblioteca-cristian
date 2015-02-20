package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Book> checkedOutBooks = new ArrayList<Book>();
    private Library library;

    public Customer(Library library){
        this.library = library;
    }

    public boolean checkout(Book book) {
        if(library.removeBook(book)) {
            checkedOutBooks.add(book);
            Message.SUCCESSFUL_CHECKOUT.print();
            return true;
        }
        Message.UNSUCCESSFUL_CHECKOUT.print();
        return false;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public boolean returnBook(Book book) {
        if(library.addBook(book) && checkedOutBooks.contains(book)){
            checkedOutBooks.remove(book);
            Message.SUCCESSFUL_RETURN.print();
            return true;
        }
        Message.UNSUCCESSFUL_RETURN.print();
        return false;
    }
}
