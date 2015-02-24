package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Book> checkedOutBooks = new ArrayList<Book>();
    private List<Movie> checkedOutMovies = new ArrayList<Movie>();
    private Library<Book> bookLibrary;

    private Library<Movie> movieLibrary;
    public void setMovieLibrary(Library<Movie> movieLibrary) {
        this.movieLibrary = movieLibrary;
    }

    public Customer(Library<Book> bookLibrary){
        this.bookLibrary = bookLibrary;
    }

    public Message checkout(Book book) {
        if(bookLibrary.removeItem(book)) {
            checkedOutBooks.add(book);
            return Message.SUCCESSFUL_CHECKOUT;
        }
        return Message.UNSUCCESSFUL_CHECKOUT;
    }

    public Message returnBook(Book book) {
        if(checkedOutBooks.contains(book) && bookLibrary.addItem(book)){
            checkedOutBooks.remove(book);
            return Message.SUCCESSFUL_RETURN;
        }
        return Message.UNSUCCESSFUL_RETURN;
    }

    public Message checkoutMovie(Movie movie) {
        if(movieLibrary.removeItem(movie)) {
            checkedOutMovies.add(movie);
            return Message.SUCCESSFUL_MOVIE_CHECKOUT;
        }
        return Message.UNSUCCESSFUL_MOVIE_CHECKOUT;
    }

    public Message returnMovie(Movie movie) {
        if(checkedOutMovies.contains(movie) && movieLibrary.addItem(movie)){
            checkedOutMovies.remove(movie);
            return Message.SUCCESSFUL_MOVIE_RETURN;
        }
        return Message.UNSUCCESSFUL_MOVIE_RETURN;
    }

    public List<Book> checkAvailableBooks() {
        return bookLibrary.listAvailableItems();
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public List<Movie> checkAvailableMovies() {
        return movieLibrary.listAvailableItems();
    }

    public List<Movie> getCheckedOutMovies() {
        return checkedOutMovies;
    }
}
