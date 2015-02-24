package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ManualBookCheckoutOptionTest {

    private ManualBookCheckoutOption manualCheckout;
    private Presenter presenter;
    private Customer alice;
    private Book harryPotter1;

    @Before
    public void setUp() throws Exception{
        presenter = mock(Presenter.class);
        alice = mock(Customer.class);
        manualCheckout = new ManualBookCheckoutOption(alice, presenter);
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        when(presenter.getBookFromUser()).thenReturn(harryPotter1);
        when(alice.checkout(harryPotter1)).thenReturn(Message.SUCCESSFUL_CHECKOUT);
    }

    @Test
    public void shouldGetEnteredBookFromPresenter(){
        manualCheckout.onSelect();
        verify(presenter).getBookFromUser();
    }

    @Test
    public void shouldDelegateCheckoutWithCorrectBook(){
        manualCheckout.onSelect();
        verify(alice).checkout(harryPotter1);
    }

    @Test
    public void shouldDisplayCheckoutResult(){
        manualCheckout.onSelect();
        verify(presenter).displayMessage(alice.checkout(harryPotter1));
    }
}
