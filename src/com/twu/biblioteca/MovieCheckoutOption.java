package com.twu.biblioteca;

import java.util.List;

public class MovieCheckoutOption extends ItemActionOption{

    public MovieCheckoutOption(Customer customer, Presenter presenter) {
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    List<? extends Item> getItems() {
        return customer.checkAvailableMovies();
    }

    @Override
    void displayNoItemsMessage() {
        presenter.displayMessage(Message.NO_MOVIES);
    }

    @Override
    Option convertItemToOption(Item item) {
        return new MovieToCheckoutAsOption(customer,presenter,(Movie) item);
    }

    @Override
    Option getManualOption() {
        return new MovieManualCheckoutOption(customer, presenter);
    }

    @Override
    public String toString() {
        return "Checkout a movie";
    }
}
