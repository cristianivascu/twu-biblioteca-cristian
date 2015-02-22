package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BookToReturnAsOptionTest {

    private Customer alice;
    private Presenter presenter;
    private Book harryPotter1;
    private BookToReturnAsOption bookToReturnAsOption;

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        alice = mock(Customer.class);
        presenter = mock(Presenter.class);
        when(alice.returnBook(harryPotter1)).thenReturn(Message.SUCCESSFUL_RETURN);
        bookToReturnAsOption = new BookToReturnAsOption(alice, presenter, harryPotter1);
    }

    @Test
    public void shouldDelegateReturnWithCorrectBook(){
        bookToReturnAsOption.onSelect();
        verify(alice).returnBook(harryPotter1);
    }

    @Test
    public void shouldDisplayReturnResult(){
        bookToReturnAsOption.onSelect();
        verify(presenter).displayMessage(Message.SUCCESSFUL_RETURN);
    }



}