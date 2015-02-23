package com.twu.biblioteca;

public class ListOption implements Option {
    private Customer customer;
    private Presenter presenter;

    public ListOption(Customer customer, Presenter presenter) {
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    public void onSelect() {
        presenter.displayItemsAsList(customer.checkAvailableBooks());
    }

    @Override
    public String toString() {
        return "List available books";
    }
}
