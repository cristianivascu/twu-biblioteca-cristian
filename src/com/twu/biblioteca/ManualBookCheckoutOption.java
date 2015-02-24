package com.twu.biblioteca;

public class ManualBookCheckoutOption implements Option{

    private Customer customer;
    private Presenter presenter;

    public ManualBookCheckoutOption(Customer customer, Presenter presenter){
        this.customer = customer;
        this.presenter = presenter;
    }

    public void onSelect() {
        Book enteredBook = presenter.getBookFromUser();
        Message result = customer.checkout(enteredBook);
        presenter.displayMessage(result);

    }

    @Override
    public String toString() {
        return "Enter a book manually";
    }
}
