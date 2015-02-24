package com.twu.biblioteca.options;


import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Message;
import com.twu.biblioteca.Presenter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BookManualCheckoutOptionTest {

    private BookManualCheckoutOption manualCheckout;
    private Presenter presenter;
    private Customer alice;
    private Book harryPotter1;

    @Before
    public void setUp() throws Exception{
        presenter = mock(Presenter.class);
        alice = mock(Customer.class);
        manualCheckout = new BookManualCheckoutOption(alice, presenter);
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        when(presenter.getBookFromUser()).thenReturn(harryPotter1);
        when(alice.checkoutBook(harryPotter1)).thenReturn(Message.SUCCESSFUL_BOOK_CHECKOUT);
    }

    @Test
    public void shouldGetEnteredBookFromPresenter(){
        manualCheckout.onSelect();
        verify(presenter).getBookFromUser();
    }

    @Test
    public void shouldDelegateCheckoutWithCorrectBook(){
        manualCheckout.onSelect();
        verify(alice).checkoutBook(harryPotter1);
    }

    @Test
    public void shouldDisplayCheckoutResult(){
        manualCheckout.onSelect();
        verify(presenter).displayMessage(alice.checkoutBook(harryPotter1));
    }
}
