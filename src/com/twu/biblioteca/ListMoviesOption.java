package com.twu.biblioteca;

import java.util.List;

public class ListMoviesOption implements Option {
    private Customer customer;
    private Presenter presenter;

    public ListMoviesOption(Customer customer, Presenter presenter) {
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    public void onSelect() {
        List<Movie> movies = customer.checkAvailableMovies();
        if (movies.isEmpty()) {
            presenter.displayMessage(Message.NO_MOVIES);
        } else {
            presenter.displayItemsAsList(movies);
        }
    }

    @Override
    public String toString() {
        return "List available movies";
    }
}
