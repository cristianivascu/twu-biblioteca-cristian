package com.twu.biblioteca;

import java.util.List;

public class CheckoutOption implements Option{
    private Customer customer;
    private Presenter presenter;

    public CheckoutOption(Customer customer, Presenter presenter) {
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    public void onSelect() {
        List<Book> books = customer.checkAvailableBooks();
        if(books.isEmpty()){
            presenter.displayMessage(Message.NO_BOOKS);
        }else {
            presenter.displayItemsAsMenuOptions(books);
            int chosenBookNumber = presenter.getUserInput(books.size());
            Book selectedBook = books.get(chosenBookNumber - 1);
            Message checkoutResult = customer.checkout(selectedBook);
            presenter.displayMessage(checkoutResult);
        }
    }

    @Override
    public String toString() {
        return "Checkout a book";
    }
}
