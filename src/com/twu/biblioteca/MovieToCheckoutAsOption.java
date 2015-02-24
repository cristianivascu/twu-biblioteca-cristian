package com.twu.biblioteca;

public class MovieToCheckoutAsOption implements Option {
    private Customer customer;
    private Presenter presenter;
    private Movie movie;

    public MovieToCheckoutAsOption(Customer customer, Presenter presenter, Movie movie) {
        this.customer = customer;
        this.presenter = presenter;
        this.movie = movie;
    }

    @Override
    public void onSelect() {
        Message result = customer.checkoutMovie(movie);
        presenter.displayMessage(result);
    }

    @Override
    public String toString() {
        return movie.toString();
    }
}
