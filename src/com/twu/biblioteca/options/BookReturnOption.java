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
    Option convertItemToOption(Item item) {
        return new BookToReturnAsOption(customer,presenter,(Book) item);
    }

    @Override
    Option getManualOption() {
        return new BookManualReturnOption(customer, presenter);
    }

    @Override
    public String toString() {
        return "Return a book";
    }
}
