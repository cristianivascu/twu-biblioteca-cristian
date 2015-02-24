package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

public class BookManualCheckoutOption implements Option {

    private Customer customer;
    private Presenter presenter;

    public BookManualCheckoutOption(Customer customer, Presenter presenter){
        this.customer = customer;
        this.presenter = presenter;
    }

    public void onSelect() {
        Book enteredBook = presenter.getBookFromUser();
        Message result = customer.checkoutBook(enteredBook);
        presenter.displayMessage(result);

    }

    @Override
    public String toString() {
        return "Enter a book manually";
    }
}
