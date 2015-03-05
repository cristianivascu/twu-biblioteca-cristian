package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

import java.util.List;

public class MovieReturnOption extends ItemActionOption {

    public MovieReturnOption(Customer customer, Presenter presenter){
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    List<? extends Item> getItems() {
        return customer.getCheckedOutMovies();
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
        Message result =customer.returnMovie((Movie) item);
        presenter.displayMessage(result);

    }

    @Override
    public String toString() {
        return "Return a movie";
    }
}
