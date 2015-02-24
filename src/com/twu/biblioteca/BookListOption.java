package com.twu.biblioteca;

import java.util.List;

public class BookListOption implements Option {
    private Customer customer;
    private Presenter presenter;

    public BookListOption(Customer customer, Presenter presenter) {
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    public void onSelect() {
        List<Book> books = customer.checkAvailableBooks();
        if (books.isEmpty()) {
            presenter.displayMessage(Message.NO_BOOKS);
        } else {
            presenter.displayItemsAsList(books);
        }
    }

    @Override
    public String toString() {
        return "List available books";
    }
}
