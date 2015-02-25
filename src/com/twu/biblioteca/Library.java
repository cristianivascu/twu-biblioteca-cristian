package com.twu.biblioteca;

import com.twu.biblioteca.options.*;

import java.util.*;

public class Library {
    private Inventory<Movie> movieDatabase;
    private Inventory<Book> bookDatabase;
    private List<UserAccount> userDatabase = new ArrayList<UserAccount>();
    private List<Option> mainMenuOptions;
    private Presenter presenter = new Presenter();

    public void init(){
        Book harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        Book harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        Map<Book,Integer> books = new HashMap<Book, Integer>();
        books.put(harryPotter1, 3);
        books.put(harryPotter2, 1);
        bookDatabase = new Inventory<Book>(books);

        Movie godfather = new Movie("The Godfather",1972,"Francis Ford Coppola");
        Map<Movie,Integer> movies = new HashMap<Movie, Integer>();
        movies.put(godfather, 1);
        movieDatabase = new Inventory<Movie>(movies);
    }

    public void register(){
        userDatabase.add(new UserAccount("alice","alice@inwonderland.com",7773141,"777-7777","abcde",this));
        userDatabase.add(new UserAccount("bob","bob@thebuilder.com",7778978,"999-9999","abcde",this));
    }

    public boolean login(){
        /*this looks like a task for Presenter, but given the nature of the data it will be left here for now*/
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your library number");
        String libraryNumber = in.nextLine();
        System.out.println("Enter your password");
        String password = in.nextLine();
        /****************/

        for(UserAccount user : userDatabase){
            if(user.getPassword().equals(password) && user.getLibraryNumber().equals(libraryNumber)){
                presenter.displayMessage(Message.LOGIN_SUCCESSFUL);
                return true;
            }
        }
        presenter.displayMessage(Message.LOGIN_UNSUCCESSFUL);
        return false;

    }



    private void initialiseMainMenu(Customer customer){
        mainMenuOptions = new ArrayList<Option>();
        mainMenuOptions.add(new BookListOption(customer, presenter));
        mainMenuOptions.add(new BookCheckoutOption(customer, presenter));
        mainMenuOptions.add(new BookReturnOption(customer, presenter));
        mainMenuOptions.add(new MovieListOption(customer,presenter));
        mainMenuOptions.add(new MovieCheckoutOption(customer,presenter));
        mainMenuOptions.add(new MovieReturnOption(customer,presenter));
        mainMenuOptions.add(new QuitOption());
    }

    Inventory<Book> getBookDatabase() {
        return bookDatabase;
    }

    Inventory<Movie> getMovieDatabase() {
        return movieDatabase;
    }

}
