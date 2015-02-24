package com.twu.biblioteca;

import java.util.List;

public class ReturnOption extends ItemActionOption{

    public ReturnOption(Customer customer, Presenter presenter){
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
        return new ManualBookReturnOption(customer, presenter);
    }

    @Override
    public String toString() {
        return "Return a book";
    }
}
