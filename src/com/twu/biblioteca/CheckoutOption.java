package com.twu.biblioteca;

import java.util.List;

public class CheckoutOption extends ItemActionOption{

    public CheckoutOption(Customer customer, Presenter presenter) {
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    List<? extends Item> getItems() {
        return customer.checkAvailableBooks();
    }

    @Override
    void displayNoItemsMessage() {
        presenter.displayMessage(Message.NO_BOOKS);
    }

    @Override
    Option convertItemToOption(Item item) {
        return new BookToCheckoutAsOption(customer,presenter,(Book) item);
    }

    @Override
    Option getManualOption() {
        return new ManualCheckoutOption(customer, presenter);
    }

    @Override
    public String toString() {
        return "Checkout a book";
    }
}
