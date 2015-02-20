package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserInterfaceTest {

    private Customer alice;
    private Presenter presenter;
    private Book harryPotter1;
    private Book harryPotter2;
    private List<Book> books;
    private UserInterface ui;

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        books = new ArrayList<Book>();
        books.add(harryPotter1);
        books.add(harryPotter2);
        alice = mock(Customer.class);
        presenter = mock(Presenter.class);
        ui = new UserInterface(alice, presenter);
    }

    @Test
    public void shouldReturnValidUserInput() {

        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        System.setIn(in);
        assertEquals(4, ui.getUserInput(5));
        System.setIn(System.in);

    }

    @Test
    public void shouldDisplayErrorWhenInputInvalid() {
        ByteArrayInputStream in = new ByteArrayInputStream("6\n3".getBytes());
        System.setIn(in);
        ui.getUserInput(5);
        verify(presenter).displayMessage(Message.INVALID_MENU_OPTION);
        System.setIn(in);
    }
}
