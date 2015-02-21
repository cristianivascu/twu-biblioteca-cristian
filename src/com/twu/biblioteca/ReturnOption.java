package com.twu.biblioteca;

import java.util.List;

public class ReturnOption implements Option{

    Customer customer;
    Presenter presenter;

    public ReturnOption(Customer customer, Presenter presenter){
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    public void onSelect() {
        List<Book> books = customer.getCheckedOutBooks();
        if(books.isEmpty()){
            presenter.displayMessage(Message.NO_BOOKS);
        }else{
            presenter.displayItemsAsMenuOptions(books);
            int chosenBookNumber = presenter.getUserInput(books.size());
            Book selectedBook = books.get(chosenBookNumber - 1);
            Message returnResult = customer.returnBook(selectedBook);
            presenter.displayMessage(returnResult);
        }
    }

    @Override
    public String toString() {
        return "Return a book";
    }
}
