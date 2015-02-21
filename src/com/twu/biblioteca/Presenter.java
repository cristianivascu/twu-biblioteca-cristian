package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class Presenter {

    public <T> String displayItemsAsMenuOptions(List<T> items){
        System.out.println("Choose an option by typing the corresponding number:");
        String result = "";
        int counter = 1;
        for(T item : items){
            result+=counter + ". " + item+"\n";
            counter++;
        }
        System.out.print(result);
        return result;
    }

    public void displayMessage(Message m){
        System.out.println(m);
    }

    public int getUserInput(int maxValue) {
        int minValue = 1;
        Scanner in = new Scanner(System.in);
        int userInput = in.nextInt();
        while(userInput>maxValue || userInput<minValue){
            displayMessage(Message.INVALID_MENU_OPTION);
            userInput = in.nextInt();
        }
        return userInput;
    }
}
