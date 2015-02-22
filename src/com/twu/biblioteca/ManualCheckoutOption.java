package com.twu.biblioteca;

public class ManualCheckoutOption {

    Customer customer;
    Presenter presenter;

    public ManualCheckoutOption(Customer customer, Presenter presenter){
        this.customer = customer;
        this.presenter = presenter;
    }

    public void onSelect() {
        Book enteredBook = presenter.getBookFromUser();
        Message result = customer.checkout(enteredBook);
        presenter.displayMessage(result);

    }
}
