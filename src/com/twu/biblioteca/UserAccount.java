package com.twu.biblioteca;

public class UserAccount {

    private String name;
    private String email;
    private int phone;
    private String libraryNumber;
    private String password;
    private Customer customer;

    public UserAccount(String name, String email, int phone, String libraryNumber, String password, Library library) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = password;
        customer = new Customer(library.getBookDatabase(), library.getMovieDatabase());
    }

    String getPassword() {
        return password;
    }

    String getLibraryNumber() {
        return libraryNumber;
    }

    Customer getCustomerProfile() {
        return customer;
    }

    @Override
    public String toString() {
        return "Name: "+name+" Email: "+email+" Phone: "+phone;
    }
}
