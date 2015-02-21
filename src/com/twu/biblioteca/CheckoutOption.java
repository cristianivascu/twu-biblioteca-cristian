package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class CheckoutOption implements Option{
    private Customer customer;
    private Presenter presenter;

    public CheckoutOption(Customer customer, Presenter presenter) {
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    public void onSelect() {
        displayAvailableBooks();
    }

    private void displayAvailableBooks(){
        List<Book> books = customer.checkAvailableBooks();
        if(books.isEmpty()){
            presenter.displayMessage(Message.NO_BOOKS);
        }else {
            presenter.displayItemsAsMenuOptions(books);
        }
    }

}
