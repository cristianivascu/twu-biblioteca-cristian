package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOption implements Option{
    private Customer customer;
    private Presenter presenter;
    private List<Option> options = new ArrayList<Option>();

    public CheckoutOption(Customer customer, Presenter presenter) {
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    public void onSelect() {
        List<Book> books = customer.checkAvailableBooks();

        if(books.isEmpty()){
            presenter.displayMessage(Message.NO_BOOKS);
        }else {
            initialiseOptions(books);
            presenter.displayItemsAsMenuOptions(options);
            int chosenOptionNumber = presenter.getUserInput(options.size());
            Option selectedOption = options.get(chosenOptionNumber - 1);
            selectedOption.onSelect();
        }
    }

    private void initialiseOptions(List<Book> books) {
        options = new ArrayList<Option>();
        for(Book book:books){
            options.add(new BookToCheckoutAsOption(customer,presenter,book));
        }
        options.add(new ManualCheckoutOption(customer, presenter));
        options.add(new QuitOption());
    }

    public List<Option> getOptions() {
        return new ArrayList<Option>(options);
    }

    @Override
    public String toString() {
        return "Checkout a book";
    }
}
