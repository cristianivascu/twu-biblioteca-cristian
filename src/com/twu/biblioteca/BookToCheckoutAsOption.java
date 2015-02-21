package com.twu.biblioteca;

/**
 * Created by cristianivascu on 21/02/2015.
 */
public class BookToCheckoutAsOption implements Option {
    Customer customer;
    Presenter presenter;
    Book book;

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
}
