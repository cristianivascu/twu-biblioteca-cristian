package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

import java.util.List;

public class BookReturnOption extends ItemActionOption {

    public BookReturnOption(Customer customer, Presenter presenter){
        this.customer = customer;
        this.presenter = presenter;
    }

    @Override
    List<? extends Item> getItems() {
        return customer.getCheckedOutBooks();
    }

    @Override
    void displayNoItemsMessage() {
        presenter.displayMessage(Message.NO_BOOKS);
    }

    @Override
    Item getItemManually() {
        Book enteredBook = presenter.getBookFromUser();
        return enteredBook;
    }

    @Override
    void itemAction(Item item) {
        Message result =customer.returnBook((Book) item);
        presenter.displayMessage(result);

    }

    @Override
    public String toString() {
        return "Return a book";
    }
}
