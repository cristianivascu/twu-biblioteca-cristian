package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BookManualReturnOptionTest {

    private BookManualReturnOption manualReturn;
    private Presenter presenter;
    private Customer alice;
    private Book harryPotter1;

    @Before
    public void setUp() throws Exception{
        presenter = mock(Presenter.class);
        alice = mock(Customer.class);
        manualReturn = new BookManualReturnOption(alice, presenter);
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        when(presenter.getBookFromUser()).thenReturn(harryPotter1);
        when(alice.returnBook(harryPotter1)).thenReturn(Message.SUCCESSFUL_RETURN);
    }

    @Test
    public void shouldGetEnteredBookFromPresenter(){
        manualReturn.onSelect();
        verify(presenter).getBookFromUser();
    }

    @Test
    public void shouldDelegateReturnWithCorrectBook(){
        manualReturn.onSelect();
        verify(alice).returnBook(harryPotter1);
    }

    @Test
    public void shouldDisplayReturnResult(){
        manualReturn.onSelect();
        verify(presenter).displayMessage(alice.returnBook(harryPotter1));
    }
}
