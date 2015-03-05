package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class Presenter {

    public <T> void displayAsMenu(List<T> items){
        System.out.println("Choose an option by typing the corresponding number:");
        displayAsList(items);
    }

    public <T> void displayItemsAsMenu(List<T> items) {
        System.out.println("Choose an item by typing its number:");
        displayAsList(items);
        System.out.println((items.size()+1)+ ". Enter manually");
        System.out.println((items.size()+2)+ ". Exit");
    }


    private <T> String displayAsList(List<T> items) {
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

    public Book getBookFromUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a title");
        String title = in.nextLine();
        System.out.println("Enter an author");
        String author = in.nextLine();
        System.out.println("Enter a year");
        int year = in.nextInt();
        return new Book(title,author,year);
    }

    public Movie getMovieFromUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a name");
        String name = in.nextLine();
        System.out.println("Enter a director");
        String director = in.nextLine();
        System.out.println("Enter a year");
        int year = in.nextInt();
        return new Movie(name,year,director);
    }
}
