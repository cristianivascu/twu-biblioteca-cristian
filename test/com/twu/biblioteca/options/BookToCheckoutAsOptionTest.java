package com.twu.biblioteca.options;


import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Message;
import com.twu.biblioteca.Presenter;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BookToCheckoutAsOptionTest {

    private Customer alice;
    private Presenter presenter;
    private Book harryPotter1;
    private BookToCheckoutAsOption bookToCheckOutAsOption;

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        alice = mock(Customer.class);
        presenter = mock(Presenter.class);
        when(alice.checkoutBook(harryPotter1)).thenReturn(Message.SUCCESSFUL_BOOK_CHECKOUT);
        bookToCheckOutAsOption = new BookToCheckoutAsOption(alice, presenter, harryPotter1);
    }

    @Test
    public void shouldDelegateCheckoutWithCorrectBook(){
        bookToCheckOutAsOption.onSelect();
        verify(alice).checkoutBook(harryPotter1);
    }

    @Test
    public void shouldDisplayCheckoutResult(){
        bookToCheckOutAsOption.onSelect();
        verify(presenter).displayMessage(Message.SUCCESSFUL_BOOK_CHECKOUT);
    }



}
