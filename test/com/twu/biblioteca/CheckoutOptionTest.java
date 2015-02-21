package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CheckoutOptionTest {

    private Customer alice;
    private Presenter presenter;
    private Book harryPotter1;
    private List<Book> books;
    private Option checkoutOption;

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        books = new ArrayList<Book>();
        books.add(harryPotter1);
        alice = mock(Customer.class);
        when(alice.checkAvailableBooks()).thenReturn(books);
        presenter = mock(Presenter.class);
        when(presenter.getUserInput(books.size())).thenReturn(1);
        checkoutOption = new CheckoutOption(alice, presenter);
    }

    @Test
    public void shouldDisplayAvailableBooksAsList(){
        checkoutOption.onSelect();
        verify(alice).checkAvailableBooks();
        verify(presenter).displayItemsAsMenuOptions(books);
    }

    @Test
    public void shouldDisplayErrorMessageIfNoBooksAreAvailable(){
        when(alice.checkAvailableBooks()).thenReturn(new ArrayList<Book>());
        checkoutOption = new CheckoutOption(alice, presenter);
        checkoutOption.onSelect();
        verify(presenter).displayMessage(Message.NO_BOOKS);
    }

    @Test
    public void shouldProvideCorrectMenuLimitToPresenter(){
        checkoutOption.onSelect();
        verify(presenter).getUserInput(books.size());
    }

    @Test
    public void shouldDelegateCheckoutWithCorrectBook(){
        checkoutOption.onSelect();
        verify(alice).checkout(harryPotter1);
    }

}
