package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static void main(String[] args) {

        Book harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        Book harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        Map<Book,Integer> books = new HashMap<Book, Integer>();
        books.put(harryPotter1, 3);
        books.put(harryPotter2, 1);
        Library bangalore = new Library(books);
        Customer alice = new Customer(bangalore);
        List<Option> mainMenuOptions = new ArrayList<Option>();
        Presenter presenter = new Presenter();
        mainMenuOptions.add(new ListOption());
        mainMenuOptions.add(new CheckoutOption(alice, presenter));
        mainMenuOptions.add(new ReturnOption());
        mainMenuOptions.add(new QuitOption());
        UserInterface ui = new UserInterface(alice, presenter, mainMenuOptions);

        ui.mainMenu();


        System.out.println("Hello, world!");
    }
}
