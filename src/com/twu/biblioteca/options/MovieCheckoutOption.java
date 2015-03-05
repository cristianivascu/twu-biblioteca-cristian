package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

import java.util.List;

public class MovieCheckoutOption extends ItemActionOption {

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
    Item getItemManually() {
        Movie enteredMovie = presenter.getMovieFromUser();
        return enteredMovie;
    }

    @Override
    void itemAction(Item item) {
        Message result =customer.checkoutMovie((Movie) item);
        presenter.displayMessage(result);

    }

    @Override
    public String toString() {
        return "Checkout a movie";
    }
}
