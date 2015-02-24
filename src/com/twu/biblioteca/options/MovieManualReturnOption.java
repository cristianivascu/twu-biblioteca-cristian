package com.twu.biblioteca.options;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Message;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Presenter;
import com.twu.biblioteca.options.Option;

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
