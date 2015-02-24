package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Book> checkedOutBooks = new ArrayList<Book>();
    private List<Movie> checkedOutMovies = new ArrayList<Movie>();
    private Inventory<Book> bookInventory;
    private Inventory<Movie> movieInventory;

    public Customer(Inventory<Book> bookInventory, Inventory<Movie> movieInventory) {
        this.bookInventory = bookInventory;
        this.movieInventory = movieInventory;
    }

    public Message checkoutBook(Book book) {
        if(bookInventory.removeItem(book)) {
            checkedOutBooks.add(book);
            return Message.SUCCESSFUL_BOOK_CHECKOUT;
        }
        return Message.UNSUCCESSFUL_BOOK_CHECKOUT;
    }

    public Message returnBook(Book book) {
        if(checkedOutBooks.contains(book) && bookInventory.addItem(book)){
            checkedOutBooks.remove(book);
            return Message.SUCCESSFUL_BOOK_RETURN;
        }
        return Message.UNSUCCESSFUL_BOOK_RETURN;
    }

    public Message checkoutMovie(Movie movie) {
        if(movieInventory.removeItem(movie)) {
            checkedOutMovies.add(movie);
            return Message.SUCCESSFUL_MOVIE_CHECKOUT;
        }
        return Message.UNSUCCESSFUL_MOVIE_CHECKOUT;
    }

    public Message returnMovie(Movie movie) {
        if(checkedOutMovies.contains(movie) && movieInventory.addItem(movie)){
            checkedOutMovies.remove(movie);
            return Message.SUCCESSFUL_MOVIE_RETURN;
        }
        return Message.UNSUCCESSFUL_MOVIE_RETURN;
    }

    public List<Book> checkAvailableBooks() {
        return bookInventory.listAvailableItems();
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public List<Movie> checkAvailableMovies() {
        return movieInventory.listAvailableItems();
    }

    public List<Movie> getCheckedOutMovies() {
        return checkedOutMovies;
    }
}
