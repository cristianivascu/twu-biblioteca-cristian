package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CheckoutOptionTest {

    private Customer alice;
    private Presenter presenter;
    private CheckoutOption checkoutOption;
    private int totalOptions;

    @Before
    public void setUp() throws Exception{
        Book harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        List<Book> books = new ArrayList<Book>();
        books.add(harryPotter1);
        alice = mock(Customer.class);
        when(alice.checkAvailableBooks()).thenReturn(books);
        presenter = mock(Presenter.class);
        checkoutOption = new CheckoutOption(alice, presenter);
        totalOptions = books.size() + 2; //a book, enter manually, quit
        when(presenter.getUserInput(totalOptions)).thenReturn(1);

    }

    @Test
    public void shouldDisplayErrorMessageIfNoBooksAreAvailable(){
        when(alice.checkAvailableBooks()).thenReturn(new ArrayList<Book>());
        checkoutOption.onSelect();
        verify(presenter).displayMessage(Message.NO_BOOKS);
    }

    @Test
    public void shouldDisplayAvailableOptionsAsList(){
        checkoutOption.onSelect();
        verify(presenter).displayItemsAsMenuOptions(checkoutOption.getOptions());
    }

    @Test
    public void shouldProvideCorrectMenuLimitToPresenter(){
        checkoutOption.onSelect();
        verify(presenter).getUserInput(totalOptions);
    }



}
