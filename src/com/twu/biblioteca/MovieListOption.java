package com.twu.biblioteca;

import java.util.List;

public class MovieListOption implements Option {
    private Customer customer;
    private Presenter presenter;

    public MovieListOption(Customer customer, Presenter presenter) {
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
