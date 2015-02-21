package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

/**
 * Created by cristianivascu on 20/02/2015.
 */
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
        presenter.displayItemsAsMenuOptions(menuOptions);
        int optionSelected = getUserInput(menuOptions.size());
        menuOptions.get(optionSelected-1).onSelect();
    }

    public List<Option> getMenuOptions() {
        return menuOptions;
    }

    public int getUserInput(int maxValue) {
        int minValue = 1;
        Scanner in = new Scanner(System.in);
        int userInput = in.nextInt();
        while(userInput>maxValue || userInput<minValue){
            presenter.displayMessage(Message.INVALID_MENU_OPTION);
            userInput = in.nextInt();
        }
        return userInput;
    }
}
