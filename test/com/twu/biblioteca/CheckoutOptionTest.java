package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CheckoutOptionTest {

    private Customer alice;
    private Presenter presenter;
    private Book harryPotter1;
    private Book harryPotter2;
    private List<Book> books;
    private Option checkoutOption;

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        books = new ArrayList<Book>();
        books.add(harryPotter1);
        books.add(harryPotter2);
        alice = mock(Customer.class);
        presenter = mock(Presenter.class);
        checkoutOption = new CheckoutOption(alice, presenter);
    }

    @Test
    public void shouldDisplayAvailableBooksAsList(){
        when(alice.checkAvailableBooks()).thenReturn(books);
        checkoutOption.onSelect();
        verify(alice).checkAvailableBooks();
        verify(presenter).displayItemsAsMenuOptions(books);
    }

    @Test
    public void shouldDisplayErrorMessageIfNoBooksAreAvailable(){
        when(alice.checkAvailableBooks()).thenReturn(new ArrayList<Book>());
        checkoutOption.onSelect();
        verify(presenter).displayMessage(Message.NO_BOOKS);
    }

}
