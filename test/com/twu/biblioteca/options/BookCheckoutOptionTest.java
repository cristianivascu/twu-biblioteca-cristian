package com.twu.biblioteca.options;


import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Message;
import com.twu.biblioteca.Presenter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BookCheckoutOptionTest {

    private Customer alice;
    private Presenter presenter;
    private BookCheckoutOption bookCheckoutOption;
    private int totalOptions;
    private List<Book> books = new ArrayList<Book>();

    @Before
    public void setUp() throws Exception{
        Book harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        books.add(harryPotter1);
        alice = mock(Customer.class);
        when(alice.checkAvailableBooks()).thenReturn(books);
        presenter = mock(Presenter.class);
        bookCheckoutOption = new BookCheckoutOption(alice, presenter);
        totalOptions = books.size() + 2; //a book, enter manually, quit
        when(presenter.getUserInput(totalOptions)).thenReturn(1);

    }

    @Test
    public void shouldDisplayErrorMessageIfNoBooksAreAvailable(){
        when(alice.checkAvailableBooks()).thenReturn(new ArrayList<Book>());
        bookCheckoutOption.onSelect();
        verify(presenter).displayMessage(Message.NO_BOOKS);
    }

    @Test
    public void shouldDisplayAvailableBooksAsList(){
        bookCheckoutOption.onSelect();
        verify(presenter).displayItemsAsMenu(books);
    }

    @Test
    public void shouldProvideCorrectMenuLimitToPresenter(){
        bookCheckoutOption.onSelect();
        verify(presenter).getUserInput(totalOptions);
    }

}
