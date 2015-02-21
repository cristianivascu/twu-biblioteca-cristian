package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Customer customer;
    private Presenter presenter;

    private List<Option> menuOptions;

    public UserInterface(Customer customer, Presenter presenter, List<Option> menuOptions) {
        this.customer = customer;
        this.presenter = presenter;
        this.menuOptions = menuOptions;
    }

    public void mainMenu(){
        Option optionSelected;
        do{
            presenter.displayItemsAsMenuOptions(menuOptions);
            int userInput = presenter.getUserInput(menuOptions.size());
            optionSelected = menuOptions.get(userInput-1);
            optionSelected.onSelect();
        }while(!(optionSelected instanceof QuitOption));
    }

    public List<Option> getMenuOptions() {
        return menuOptions;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Presenter getPresenter() {
        return presenter;
    }
}
