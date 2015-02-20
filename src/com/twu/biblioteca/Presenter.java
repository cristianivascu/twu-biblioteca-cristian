package com.twu.biblioteca;

import java.util.List;

public class Presenter {

    public static <T> String displayItemsAsMenuOptions(List<T> items){
        System.out.println("Choose an option by typing the corresponding number:");
        String result = "";
        for(T item : items){
            int optionNumber = items.indexOf(item)+1;
            result+=optionNumber + ". " + item+"\n";
        }
        System.out.print(result);
        return result;
    }

    public void displayMessage(Message m){
        System.out.println(m);
    }
}
