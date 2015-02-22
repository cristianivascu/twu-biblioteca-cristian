package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ReturnOption implements Option{

    private Customer customer;
    private Presenter presenter;
    private List<Option> options;

    public ReturnOption(Customer customer, Presenter presenter){
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    public void onSelect() {
        List<Book> books = customer.getCheckedOutBooks();

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
            options.add(new BookToReturnAsOption(customer,presenter,book));
        }
        options.add(new ManualReturnOption(customer, presenter));
        options.add(new QuitOption());
    }

    public List<Option> getOptions() {
        return new ArrayList<Option>(options);
    }

    @Override
    public String toString() {
        return "Return a book";
    }
}
