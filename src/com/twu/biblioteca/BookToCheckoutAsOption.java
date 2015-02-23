package com.twu.biblioteca;

public class BookToCheckoutAsOption implements Option {
    private Customer customer;
    private Presenter presenter;
    private Book book;

    public BookToCheckoutAsOption(Customer customer, Presenter presenter, Book book) {
        this.customer = customer;
        this.presenter = presenter;
        this.book = book;
    }

    @Override
    public void onSelect() {
        Message result = customer.checkout(book);
        presenter.displayMessage(result);
    }

    @Override
    public String toString() {
        return book.toString();
    }
}
