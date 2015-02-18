package com.twu.biblioteca;

public enum Message {

    WELCOME_MESSAGE("Welcome to Biblioteca!"),
    INVALID_MENU_OPTION("Select a valid option!"),
    SUCCESSFUL_CHECKOUT("Thank you! Enjoy the book."),
    UNSUCCESSFUL_CHECKOUT("That book is not available."),
    SUCCESSFUL_RETURN("Thank you for returning the book."),
    UNSUCCESSFUL_RETURN("That is not a valid book to return.");

    private final String message;

    Message(String message){
        this.message = message;
    }

    void print(){
        System.out.println(message);
    }

}
