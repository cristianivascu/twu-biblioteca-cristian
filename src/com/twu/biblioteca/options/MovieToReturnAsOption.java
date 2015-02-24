package com.twu.biblioteca.options;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Message;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Presenter;
import com.twu.biblioteca.options.Option;

public class MovieToReturnAsOption implements Option {
    private Customer customer;
    private Presenter presenter;
    private Movie movie;

    public MovieToReturnAsOption(Customer customer, Presenter presenter, Movie movie) {
        this.customer = customer;
        this.presenter = presenter;
        this.movie = movie;
    }

    @Override
    public void onSelect() {
        Message result = customer.returnMovie(movie);
        presenter.displayMessage(result);
    }

    @Override
    public String toString() {
        return movie.toString();
    }
}
