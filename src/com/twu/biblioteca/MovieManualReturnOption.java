package com.twu.biblioteca;

public class MovieManualReturnOption implements Option {
    private Customer customer;
    private Presenter presenter;

    public MovieManualReturnOption(Customer customer, Presenter presenter){
        this.customer = customer;
        this.presenter = presenter;
    }

    public void onSelect() {
        Movie enteredMovie = presenter.getMovieFromUser();
        Message result = customer.returnMovie(enteredMovie);
        presenter.displayMessage(result);

    }

    @Override
    public String toString() {
        return "Enter a movie manually";
    }
}
