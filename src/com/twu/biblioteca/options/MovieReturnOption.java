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
    Option convertItemToOption(Item item) {
        return new MovieToReturnAsOption(customer,presenter,(Movie) item);
    }

    @Override
    Option getManualOption() {
        return new MovieManualReturnOption(customer, presenter);
    }

    @Override
    public String toString() {
        return "Return a movie";
    }
}
