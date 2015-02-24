package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

public class BookToReturnAsOption implements Option {
    private Customer customer;
    private Presenter presenter;
    private Book book;

    public BookToReturnAsOption(Customer customer, Presenter presenter, Book book) {
        this.customer = customer;
        this.presenter = presenter;
        this.book = book;
    }

    @Override
    public void onSelect() {
        Message result = customer.returnBook(book);
        presenter.displayMessage(result);
    }

    @Override
    public String toString() {
        return book.toString();
    }
}
