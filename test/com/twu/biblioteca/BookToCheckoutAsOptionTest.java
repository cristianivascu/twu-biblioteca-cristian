package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BookToCheckoutAsOptionTest {

    private Customer alice;
    private Presenter presenter;
    private Book harryPotter1;
    private Option bookToCheckOutAsOption;

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        alice = mock(Customer.class);
        presenter = mock(Presenter.class);
        when(alice.checkout(harryPotter1)).thenReturn(Message.SUCCESSFUL_CHECKOUT);
        bookToCheckOutAsOption = new BookToCheckoutAsOption(alice, presenter, harryPotter1);
    }

    @Test
    public void shouldDelegateCheckoutWithCorrectBook(){
        bookToCheckOutAsOption.onSelect();
        verify(alice).checkout(harryPotter1);
    }

    @Test
    public void shouldDisplayCheckoutResult(){
        bookToCheckOutAsOption.onSelect();
        verify(presenter).displayMessage(Message.SUCCESSFUL_CHECKOUT);
    }



}
