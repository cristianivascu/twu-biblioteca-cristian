package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by cristianivascu on 20/02/2015.
 */
public class UserInterface {

    private Customer customer;
    private Presenter presenter;

    public UserInterface(Customer customer, Presenter presenter) {
        this.customer = customer;
        this.presenter = presenter;
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
