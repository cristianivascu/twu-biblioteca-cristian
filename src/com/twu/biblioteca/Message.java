package com.twu.biblioteca;

public enum Message {

    WELCOME_MESSAGE("Welcome to Biblioteca!"),
    INVALID_MENU_OPTION("Select a valid option!"),
    SUCCESSFUL_BOOK_CHECKOUT("Thank you! Enjoy the book."),
    UNSUCCESSFUL_BOOK_CHECKOUT("That book is not available."),
    SUCCESSFUL_BOOK_RETURN("Thank you for returning the book."),
    UNSUCCESSFUL_BOOK_RETURN("That is not a valid book to return."),
    NO_BOOKS("There are no books available!"),
    SUCCESSFUL_MOVIE_CHECKOUT("Thank you! Enjoy the movie."),
    UNSUCCESSFUL_MOVIE_CHECKOUT("That movie is not available."),
    SUCCESSFUL_MOVIE_RETURN("Thank you for returning the movie."),
    UNSUCCESSFUL_MOVIE_RETURN("That is not a valid movie to return."),
    NO_MOVIES("There are no movies available!");

    private final String message;

    Message(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
