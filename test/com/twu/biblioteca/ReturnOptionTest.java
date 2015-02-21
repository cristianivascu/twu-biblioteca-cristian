package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ReturnOptionTest {

    private Customer alice;
    private Presenter presenter;
    private Book harryPotter1;
    private List<Book> books;
    private Option returnOption;

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        books = new ArrayList<Book>();
        books.add(harryPotter1);
        alice = mock(Customer.class);
        when(alice.getCheckedOutBooks()).thenReturn(books);
        presenter = mock(Presenter.class);
        when(presenter.getUserInput(books.size())).thenReturn(1);
        returnOption = new ReturnOption(alice, presenter);
    }

    @Test
    public void shouldDisplayCheckedOutBooksAsList(){
        returnOption.onSelect();
        verify(alice).getCheckedOutBooks();
        verify(presenter).displayItemsAsMenuOptions(books);
    }

    @Test
    public void shouldDisplayErrorMessageIfNoBooksAreAvailable(){
        when(alice.getCheckedOutBooks()).thenReturn(new ArrayList<Book>());
        returnOption.onSelect();
        verify(presenter).displayMessage(Message.NO_BOOKS);
    }

    @Test
    public void shouldProvideCorrectMenuLimitToPresenter(){
        returnOption.onSelect();
        verify(presenter).getUserInput(books.size());
    }

    @Test
    public void shouldDelegateReturnWithCorrectBook(){
        returnOption.onSelect();
        verify(alice).returnBook(harryPotter1);
    }

}
