package com.twu.biblioteca;

import java.util.List;

/**
 * Created by cristianivascu on 20/02/2015.
 */
public class CheckoutOption implements Option{
    private Customer customer;
    public CheckoutOption(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void onSelect() {
        displayAvailableBooks();
    }

    private void displayAvailableBooks(){
        List<Book> books = customer.checkAvailableBooks();
        Presenter.displayItemsAsMenuOptions(books);
    }
}
