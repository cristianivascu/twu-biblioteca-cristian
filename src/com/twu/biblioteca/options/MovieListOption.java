package com.twu.biblioteca.options;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Message;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Presenter;
import com.twu.biblioteca.options.Option;

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
            presenter.displayAsList(movies);
        }
    }

    @Override
    public String toString() {
        return "List available movies";
    }
}
