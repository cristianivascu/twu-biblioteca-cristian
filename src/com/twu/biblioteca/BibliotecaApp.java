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
        Library<Book> bangalore = new Library<Book>(books);

        Movie godfather = new Movie("The Godfather",1972,"Francis Ford Coppola");
        Map<Movie,Integer> movies = new HashMap<Movie, Integer>();
        movies.put(godfather, 1);
        Library<Movie> bangaloreMovies = new Library<Movie>(movies);

        Customer alice = new Customer(bangalore);
        alice.setMovieLibrary(bangaloreMovies);

        List<Option> mainMenuOptions = new ArrayList<Option>();
        Presenter presenter = new Presenter();
        mainMenuOptions.add(new BookListOption(alice, presenter));
        mainMenuOptions.add(new BookCheckoutOption(alice, presenter));
        mainMenuOptions.add(new BookReturnOption(alice, presenter));
        mainMenuOptions.add(new MovieListOption(alice,presenter));
        mainMenuOptions.add(new MovieCheckoutOption(alice,presenter));
        mainMenuOptions.add(new MovieReturnOption(alice,presenter));
        mainMenuOptions.add(new QuitOption());
        UserInterface ui = new UserInterface(presenter, mainMenuOptions);

        ui.mainMenu();
    }
}
