package com.twu.biblioteca;

import java.util.List;

public class CheckoutOption implements Option{
    private Customer customer;
    private Presenter presenter;
    List<Book> books;

    public CheckoutOption(Customer customer, Presenter presenter) {
        this.customer = customer;
        this.presenter = presenter;
        books = customer.checkAvailableBooks();
    }

    @Override
    public void onSelect() {
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


}
